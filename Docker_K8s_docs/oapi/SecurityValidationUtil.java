/****************************************************************************
* Title             : SecurityValidationUtil.java
* Description:
* Copyright (C)     :   Copyright 2005 The Boeing Company - All Rights Reserved
* Company:  This software source file is confidential and proprietary
* information of The Boeing Company("Confidential information").
* You shall not disclose such Confidential Information and shall
* use it only in accordance with the terms of the license
* agreement you entered into with The Boeing Company.
* Change History:
* Ver.              Author        Date          Modifications.
* $Log: SecurityValidationUtil.java,v $
*/
package com.boeing.oapi.common.util;

import java.util.regex.Pattern;

import org.owasp.esapi.ESAPI;
import org.slf4j.Logger;

import com.boeing.ccl.log.manager.LogManager;
import com.boeing.oapi.common.Logger.Log;
import com.boeing.oapi.common.exception.ApplicationException;
import com.boeing.oapi.common.exception.ApplicationException.ExceptionKey;

/**
 * This is the Security validation for File/Folder path.
 * 
 * @author c.vanitha
 *
 */
public final class SecurityValidationUtil {

	/**
	 * Constant to hold the maximum length int value.
	 */
	public static final int MAX_URL_LENGTH = 1000;
	
	/**
	 * Logger variable.
	 */
	private static final Logger LOGGER = (Logger) LogManager.getLogger(SecurityValidationUtil.class.getName());

	/**
	 * This method is used for validating the File path supplied by the user by
	 * avoiding '..' in directory path.
	 *
	 * @param directoryPath
	 *            : User supplied path or dynamically constructed path
	 * @return isValidDir : returns false when directory is not valid otherwise
	 *         true
	 * @throws ApplicationException
	 *             if return value is False or any Exception
	 */
	public static boolean isValidDirectory(String directoryPath) throws ApplicationException {
		boolean isValidDir = false;
		try {
			boolean dirCheckFlag = directoryPath == null || "".equalsIgnoreCase(directoryPath.trim())
					|| directoryPath.contains("../") || directoryPath.contains("/..");
			if (dirCheckFlag) {
				LOGGER.error("Security Validation: Directory path contains invalid characters");
				throw new ApplicationException("Security Validation: Directory path contains invalid characters");
			} else {
				isValidDir = true;
			}
		} catch (Exception exception) {
			isValidDir = false;
			LOGGER.error("Security Validation: Exception while validating directory path");
			throw new ApplicationException(exception);
		}
		return isValidDir;
	}
	
	/**
	 * This method isValidUserName checks if the user valid to proceed. If the
	 * user id is null or in valid pattern (alphanumeric) then it would return
	 * true otherwise returns false.
	 *
	 * @param userID
	 *            User ID.
	 * @return true if the user id null or alphanumeric otherwise return false.
	 * @throws ApplicationException
	 *             Throws 92739 error message if the user id is non-null and
	 *             non-alphanumeric.
	 */
	public static boolean isValidUserName(String userID) throws ApplicationException {
		boolean isValidUserName = false;
		if (userID == null || Pattern.matches("[a-zA-Z0-9]{6}", userID)) {//changed the for PR 32077
			isValidUserName = true;
		} else {
			LOGGER.error(
					"Security Validation Failure: User ID is not in expected format ",
					SecurityValidationUtil.class);
			throw new ApplicationException(ExceptionKey.BusinessException);//added for PR 32077
		}
		return isValidUserName;
	}

	/**
	 * This method is used for validating the File path supplied by the user by
	 * avoiding '..' in directory path and verifying their extensions are
	 * allowed by the application.
	 *
	 * @param filePath
	 *            : User supplied path or dynamically constructed path
	 * @return isValidFile : returns false when path is not valid otherwise
	 *         returns true
	 * @throws ApplicationException
	 *             if return value is False or any Exception
	 */

	public static boolean isValidFile(String filePath) throws ApplicationException {
		boolean isValidFile = false;
		try {
			if (isValidDirectory(filePath.substring(0, filePath.lastIndexOf('/')))) {
				isValidFile = true;

			} else {
				LOGGER.error("Security Validation: File path contains invalid characters");
				throw new ApplicationException("Security Validation: File path contains invalid characters");

			}
		} catch (Exception exception) {
			LOGGER.error("Security Validation: Exception while validating file path");
			throw new ApplicationException(exception);
		}
		return isValidFile;
	}
	
	/**
	 * This method is used for avoiding SQL Injection by encoding the users
	 * input Pattern and matches method.
	 *
	 * @param jobDataRqstId
	 *            - user supplied input for the query
	 *
	 * @return boolean - Returns the false if pattern not matches
	 *
	 * @throws ApplicationException
	 *             - if any exception Occurs
	 */
	public static boolean isValidJobId(String jobDataRqstId)
			throws ApplicationException {
		boolean jobID = false;
		try {
			if (Pattern.matches("[0-9A-Za-z]+", jobDataRqstId)) {
				jobID = true;
			} else {
				LOGGER
						.error(
								"Security Validation: Exception occured while encoding sql parameter",
								SecurityValidationUtil.class);
				throw new ApplicationException(ExceptionKey.BusinessException);
			}
		} catch (Exception e) {
			LOGGER
					.error(
							"Security Validation: Exception occured while passing sql parameter",
							SecurityValidationUtil.class);
			throw new ApplicationException(ExceptionKey.BusinessException,e);
		}
		return jobID;
	}
	
	/**
	 * @param url	-	url
	 * @return	isValidUrl
	 * @throws ApplicationException - if return value is False or any Exception
	 */
	public static boolean isValidFtcsUrl(final String url) throws ApplicationException {
/*		boolean isValidUrl;
		Log.info("Given Value: " + url);	
		if (ESAPI.validator().isValidInput("vaidateBoeingUrl", url, "BOEINGURL", MAX_URL_LENGTH,
				true)) {
			isValidUrl = true;
		} else {
			Log.error(
					"Security Validation: Invalid Characters found in URL");
			throw new ApplicationException(ExceptionKey.BusinessException);
		}
		
		return isValidUrl;*/
		return true;
	} 
	/**
     * Default Constructor.
     */
	private SecurityValidationUtil(){
		super();
	}
}
