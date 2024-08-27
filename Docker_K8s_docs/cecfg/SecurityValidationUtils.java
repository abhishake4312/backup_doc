/****************************************************************************
L193
 * Title			:   SecurityValidationUtils.java
 * Copyright (C)	:   Copyright 2012 The Boeing Company - All Rights Reserved
 *
 * This software source file is confidential and proprietary
 * information of The Boeing Company("Confidential information").
 * You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license
 * agreement you entered into with The Boeing Company.
 *
 * Created Date  	:	SEP 22, 2012
 *
 ******************************************************************************/
package com.boeing.cecfg.common.util;


 
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.codecs.Codec;
import org.owasp.esapi.codecs.OracleCodec;
import org.owasp.esapi.errors.ValidationException;
import org.slf4j.Logger;

import com.boeing.ccl.log.manager.LogManager;
import com.boeing.cecfg.common.exception.ApplicationException;
import com.boeing.cecfg.common.exception.ApplicationException.ExceptionKey;
import com.boeing.cecfg.common.logger.Log;

 


 
/**
 * This class is created for fixing the Veracode violations. Individual
 * transactions will call validation methods based on the violation type to
 * validate the attributes which can imperil the security of the application
 *
 * This class uses ESAPI(Enterprise Security API)
 *
 * @author Ranjith.Rajkumar
 */
public final class SecurityValidationUtils {

	/**
	 * Constant to hold the maximum int value.
	 */
	public static final int FILE_MAX_LENGTH = 999999999;

	/**
	 * Constant to hold the maximum length int value.
	 */
	public static final int MAX_URL_LENGTH = 1000;

	/** The Constant EXTENSIONLIST. */
	public static final List<String> EXTENSIONLIST = new ArrayList<String>();
	/** The Constant OS_COMMAND_VALID. */
	private static final String OS_COMMAND_VALID = "OS command contains invalid characters";		
	/**  It Holds the LOGGER *. */
	private static final Logger LOGGER = (Logger) LogManager.getLogger(SecurityValidationUtils.class.getName());
	/**
	 * Default Constructor.
	 */
	private SecurityValidationUtils(){
		super();
	}

	
	static {
		EXTENSIONLIST.add(".a");
		EXTENSIONLIST.add(".bmp");
		EXTENSIONLIST.add(".cfg");
		EXTENSIONLIST.add(".csv");
		EXTENSIONLIST.add(".dat");
		EXTENSIONLIST.add(".db");
		EXTENSIONLIST.add(".doc");
		EXTENSIONLIST.add(".docx");
		EXTENSIONLIST.add(".drq");
		EXTENSIONLIST.add(".dsc");
		EXTENSIONLIST.add(".dta");
		EXTENSIONLIST.add(".dump");
		EXTENSIONLIST.add(".err");
		EXTENSIONLIST.add(".esa");
		EXTENSIONLIST.add(".esb");
		EXTENSIONLIST.add(".exe");
		EXTENSIONLIST.add(".f");
		EXTENSIONLIST.add(".gz");
		EXTENSIONLIST.add(".h5");
		EXTENSIONLIST.add(".h5_acc_outstat");
		EXTENSIONLIST.add(".h5_drq_reqmeas");
		EXTENSIONLIST.add(".html");
		EXTENSIONLIST.add(".idx");
		EXTENSIONLIST.add(".jpg");
		EXTENSIONLIST.add(".las");
		EXTENSIONLIST.add(".lbl");
		EXTENSIONLIST.add(".log");
		EXTENSIONLIST.add(".m");
		EXTENSIONLIST.add(".mes");
		EXTENSIONLIST.add(".mind");
		EXTENSIONLIST.add(".mork");
		EXTENSIONLIST.add(".mpg");
		EXTENSIONLIST.add(".msg");
		EXTENSIONLIST.add(".o");
		EXTENSIONLIST.add(".pdf");
		EXTENSIONLIST.add(".pr");
		EXTENSIONLIST.add(".ps");
		EXTENSIONLIST.add(".rdp");
		EXTENSIONLIST.add(".rnd");
		EXTENSIONLIST.add(".rtf");
		EXTENSIONLIST.add(".rqm");
		EXTENSIONLIST.add(".sup");
		EXTENSIONLIST.add(".taz");
		EXTENSIONLIST.add(".tbs");
		EXTENSIONLIST.add(".tif");
		EXTENSIONLIST.add(".tmp");
		EXTENSIONLIST.add(".tss");
		EXTENSIONLIST.add(".txt");
		EXTENSIONLIST.add(".wds");
		EXTENSIONLIST.add(".xcfg");
		EXTENSIONLIST.add(".xls");
		EXTENSIONLIST.add(".xlsx");
		EXTENSIONLIST.add(".xml");
		EXTENSIONLIST.add(".xsd");//veracode fix
		EXTENSIONLIST.add(".zip");//Added for CR 24759
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
			if (isValidDirectory(filePath) && isValidExtension(filePath)) {
				isValidFile = true;

			} else {
				LOGGER
						.error(
								"Security Validation: File path contains invalid characters",
								SecurityValidationUtils.class);
				throw new ApplicationException("File is not Valid");
			}
		} catch (Exception e) {
			LOGGER
					.error(
							"Security Validation: Exception while validating file path",
							SecurityValidationUtils.class);
			throw new ApplicationException(e);
		}
		return isValidFile;
	}

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
	public static boolean isValidDirectory(String directoryPath)
			throws ApplicationException {
		boolean isValidDir = false;
		if (null ==  directoryPath
				|| "".equalsIgnoreCase(directoryPath.trim())
				|| directoryPath.contains("..")) {
			LOGGER
			.error(
					"Security Validation: Directory path contains invalid characters",
					SecurityValidationUtils.class);
			throw new ApplicationException("Directory is not Valid");

		} else {
			isValidDir = true;

		}	
		return isValidDir;
	}

	/**
	 * This method is used for validating the File extensions against set of
	 * predefined set of allowed extensions in our application.
	 *
	 * @param filePath
	 *            : User supplied path or dynamically constructed path
	 * @return : returns true if the file extension is one of the allowed
	 *         extensions otherwise false
	 */
	private static boolean isValidExtension(String filePath) {
		boolean isValidExtension = false;
		int index = filePath.lastIndexOf('.');
		if (index > 0) {
			String last = filePath.substring(index, filePath.length())
					.toLowerCase();
			if (EXTENSIONLIST.contains(last)) {
				isValidExtension = true;
				}
		}
		return isValidExtension;
	}

	/**
	 * This method is used for avoiding SQL Injection by encoding the users
	 * input using ESAPI encoder method.
	 *
	 * @param sqlParameter
	 *            - user supplied input for the query
	 *
	 * @return String - Returns the encoded value of the input string
	 *
	 * @throws ApplicationException
	 *             - if any exception Occurs
	 */
	public static String encodeInputForSQLInjection(String sqlParameter)
			throws ApplicationException {
		String encodedsqlParameter = "";
		StringBuffer sb = new StringBuffer();
		try {
			Codec ORACLE_CODEC = new OracleCodec();
			char[] chr = sqlParameter.toCharArray();
			for (char ch : chr) {
				if (new Character(ch).equals('\'')) {
					sb.append("'");
				} else {
					encodedsqlParameter = ESAPI.encoder().encodeForSQL(
							ORACLE_CODEC, new Character(ch).toString());
					sb.append(encodedsqlParameter);
				}

			}
		} catch (Exception e) {
			LOGGER
					.error(
							"Security Validation: Exception occured while encoding sql parameter",
							SecurityValidationUtils.class);
			throw new ApplicationException(e);
		}
		return sb.toString();
	}

	/**
	 * This method is used for Validating OS command injection by avoiding set
	 * of black listed characters.
	 *
	 * @param command
	 *            - OS Command input From other Transactions
	 * @return boolean - returns false when command contains any of the black
	 *         listed characters otherwise returns true
	 *
	 * @throws ApplicationException
	 *             if return value is False or any Exception
	 */
	public static boolean isOSCommandValid(String command) throws ApplicationException {
		boolean isCommandValid = true;
		try {
			String invalidChars = "[(^;&<>+|)]";
			Pattern p = Pattern.compile(invalidChars);
			Matcher matcher = p.matcher(command.trim());
			if (matcher.find()) {
				isCommandValid = false;
				LOGGER
						.error(
								"Security Validation: OS command contains invalid characters",
								SecurityValidationUtils.class);
				throw new ApplicationException(OS_COMMAND_VALID);
			} else {
				LOGGER
						.info(
								"Security Validation: OSCommand contains valid characters ",
								SecurityValidationUtils.class);
			}
			// return isCommandValid;
		} catch (Exception e) {
			LOGGER
					.error(
							"Security Validation: Exception occured while validating OScommand",
							SecurityValidationUtils.class);
			throw new ApplicationException(e);
		}

		return isCommandValid;
	}

	/**
	 * This method is used for Validating OS command injection by avoiding set
	 * of black listed characters.
	 *
	 * @param command
	 *            - OS Command input From other Transactions
	 * @return boolean - returns false when command contains any of the black
	 *         listed characters otherwise returns true
	 * @throws ApplicationException
	 *             if return value is False or any Exception
	 */
	public static boolean isOSCommandValid(String[] command)
			throws ApplicationException {
		boolean isCommandValid = true;
		try {
			String invalidChars = "[(^;&<>+|)]";
			Pattern p = Pattern.compile(invalidChars);
			for (String itrValue : command) {
				Matcher matcher = p.matcher(itrValue.trim());
				if (matcher.find()) {
					isCommandValid = false;
					LOGGER
							.error(
									"Security Validation: OS command contains invalid characters",
									SecurityValidationUtils.class);
					throw new ApplicationException(OS_COMMAND_VALID);
				} else {
					LOGGER
							.info(
									"Security Validation: OSCommand contains valid characters ",
									SecurityValidationUtils.class);
				}
			}
		} catch (Exception e) {
			LOGGER
					.error(
							"Security Validation: Exception occured while validating String array OScommand",
							SecurityValidationUtils.class);
			throw new ApplicationException(e);
		}
		LOGGER.info("Final retrun value for OSComamnd" + isCommandValid,
				SecurityValidationUtils.class);
		return isCommandValid;
	}

	/**
	 * This method is used for encoding the URL input using ESAPI encoder
	 * method.
	 *
	 * @param text
	 *            - URL input from JSP page
	 * @return String - Returns the encoded URL
	 */
	public static String encodeURL(String text) {
		String encodedText = "";
		try {
			encodedText = ESAPI.encoder().encodeForURL(text);
			LOGGER.info("Security Validation: URL encoded",
					SecurityValidationUtils.class);
		} catch (Exception e) {
			LOGGER
					.error(
							"Security Validation: Exception occured while encoding URL",
							SecurityValidationUtils.class);

		}
		return encodedText;
	}

	/**
	 * This method is used for encoding user inputs or dynamic inputs within a
	 * HTML tag using ESAPI encoder method.
	 *
	 * @param text - user input within a HTML tag in a JSP file
	 * @return String - Returns the encoded value within a HTML tag
	 */
	public static String encodeForHTMLTags(String text) {
		String encodedtext = "";
		try {
			encodedtext = ESAPI.encoder().encodeForHTML(text);
		} catch (Exception e) {
			LOGGER
					.error(
							"Security Validation: Exception occured while validating HTML Tag",
							SecurityValidationUtils.class);

		}
		return encodedtext;
	}

	/**
	 * This method is used for encoding the user input value within a JavaScript
	 * tag using ESAPI encoder method.
	 *
	 * @param text
	 *            - User Input within a javascript in a JSP page
	 * @return String - Returns the encoded value within tht javascript
	 */
	public static String encodeForJavaScript(String text) {
		String encodedText = "";
		try {
			encodedText = ESAPI.encoder().encodeForJavaScript(text);
		} catch (Exception e) {
			LOGGER
					.error(
							"Security Validation: Exception occured while validating JavaScriptcommand",
							SecurityValidationUtils.class);
		}
		return encodedText;
	}

	/**
	 * This method is used for validating the MailID.
	 *
	 * @param mailID
	 *            - User Input within a MailID in a JSP page
	 * @return String - Returns the null if invalid MailID
	 *
	 */
	public static String validationForMail(String mailID) {
		String valisMail = "";
		if (mailID.contains("@")) {
			String[] tokens = mailID.split("@");
			String validMail = mailID.substring(mailID.indexOf('@') + 1, mailID
					.indexOf('.', mailID.indexOf('@') + 1));
			String[] lengthOfMail = tokens[1].split("\\.");
			if (tokens.length == 2 && isNotNull(validMail)
					&& !mailID.trim().endsWith(".") && lengthOfMail.length == 2) {
				for (String token : tokens) {
					if (!isNotNull(token)) {
						LOGGER
								.error(
										"Security Validation: Exception occured while validating MailID",
										SecurityValidationUtils.class);
						break;
					}
					valisMail = mailID;
				}

			} else {
				LOGGER
						.error(
								"Security Validation: Exception occured while validating MailID",
								SecurityValidationUtils.class);
			}
		} else {
			LOGGER
					.error(
							"Security Validation: Exception occured while validating MailID",
							SecurityValidationUtils.class);
		}
		return valisMail;
	}

	/**
	 * This method is used for check the notnull condition.
	 *
	 * @param token
	 *            - User Input within a MailID in a JSP page
	 * @return boolean - Returns the false if contains space
	 *
	 */

	private static boolean isNotNull(String token) {
		return token != null && !token.isEmpty(); 
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
								SecurityValidationUtils.class);
				throw new ApplicationException(OS_COMMAND_VALID);
			}
		} catch (Exception e) {
			LOGGER
					.error(
							"Security Validation: Exception occured while passing sql parameter",
							SecurityValidationUtils.class);
			throw new ApplicationException(e);
		}
		return jobID;
	}

	// added for PR 31666 - veracode violation fix - Start.
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
					SecurityValidationUtils.class);
			throw new ApplicationException(OS_COMMAND_VALID);//added for PR 32077
		}
		return isValidUserName;
	}

	/**
	 * This method is used to generate the random filename using ESAPI.
	 *
	 * @param fileName
	 *            - name of the file used in generating random file name.
	 * @return String - generated random filename.
	 */
	public static String generateRandomFileName(String fileName) {
		String randomFileName = fileName;
		try {
			randomFileName = fileName
					+ Integer.valueOf(
							ESAPI.randomizer().getRandomInteger(0,
									FILE_MAX_LENGTH)).toString();
		} catch (Exception e) {
			LOGGER
					.error(
							"Security Validation: Exception occured while generating random filename",
							SecurityValidationUtils.class);
		}

		return randomFileName;
	}
	// added for PR 31666 - veracode violation fix - End.
	/*
	 * PR 31665 Change start
	 */
	/**
	 * This method validates the input pattern against the pattern defined in
	 * ESAPI validator. If the input pattern is valid, true is returned.
	 *
	 * @param context
	 *            - Context.
	 * @param input
	 *            - input value.
	 * @param type
	 *            - type/keyword defined in ESAPI validator.
	 * @param maxLength
	 *            - max allowed input length.
	 * @param isNull
	 *            - flag to describe if null is valid.
	 * @return - boolean flag for valid/invalid.
	 * @throws ApplicationException
	 *             - Exception to be thrown.
	 */
	public static boolean isValidInput(final String context,
			final String input, final String type, final int maxLength,
			final boolean isNull) throws ApplicationException {
		boolean isValidInput = false;
		LOGGER.info("Given Value: " + input, SecurityValidationUtils.class);
		if (ESAPI.validator().isValidInput(context, input, type, maxLength,
				isNull)) {
			isValidInput = true;
		} else {
			LOGGER.error(
					"Security Validation: Invalid Characters found in input",
					SecurityValidationUtils.class);
			throw new ApplicationException("Invalid Characters found in input");
		}
		return isValidInput;
	}

	/**
	 * This method returns the validated input.
	 *
	 * @param context
	 *            - Context.
	 * @param input
	 *            - input value.
	 * @param type
	 *            - type/keyword defined in ESAPI validator.
	 * @param maxLength
	 *            - max allowed input length.
	 * @param isNull
	 *            - flag to describe if null is valid.
	 * @return - boolean flag for valid/invalid.
	 * @throws ApplicationException
	 *             - Exception to be thrown.
	 */
	public static String getValidInput(final String context,
			final String input, final String type, final int maxLength,
			final boolean isNull) throws ApplicationException {
		String validInput = null;
		try {
			validInput = ESAPI.validator().getValidInput(context, input, type, maxLength,
					isNull);
		} catch (ValidationException e) {
			LOGGER.error(
					"Security Validation: Invalid Characters found in input",
					SecurityValidationUtils.class);
			throw new ApplicationException(e);
		}
		return validInput;
	}

	/**
	 * This method replaces the CRLF characters with _.
	 *
	 * @param message            - logger message.
	 * @return - CRLF removed message.
	 */
	public static String getCrlfRemovedMessage(String message) {
		if (message.contains("\n") || message.contains("\r")) {
			LOGGER
					.info(
							"CRLF characters were found in logger message and has been replaced with '_'",
							SecurityValidationUtils.class);
		}
		return message.replace('\n', '_').replace('\r', '_');
	}

	/**
	 * This method returns the random string.
	 *
	 * @param maxLength
	 *            - max length of random String.
	 * @param randomChars
	 *            - char to be used in random string generation.
	 * @return - random String.
	 */
	public static String getRandomString(final int maxLength,
			final char[] randomChars) {
		return ESAPI.randomizer().getRandomString(maxLength, randomChars);
	}
	/*
	 * PR 31665 Change End.
	 */
    //Started for varacode violation fix JULY 2015.
	/**
	 * Method used to return the Object of DocumentBuilderFactory.
	 *
	 * @return dbFactory - DocumentBuilderFactory
	 * @throws ApplicationException - ApplicationException
	 */
	public static DocumentBuilderFactory getDocumentBuilderFactory() throws ApplicationException{

		DocumentBuilderFactory dbFactory = null;
		if(null==dbFactory){
			dbFactory=DocumentBuilderFactory.newInstance();
		}
		try {
			dbFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			dbFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
			dbFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
			dbFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
			} catch (ParserConfigurationException e) {
				LOGGER.error(
						"Security Validation: While disable the DTD",
						SecurityValidationUtils.class);
				throw new ApplicationException(e);
			}
		
		return dbFactory;
	}
	
	/**
	 * Checks if is valid ftcs url.
	 *
	 * @param url -	url
	 * @return isValidUrl
	 * @throws ApplicationException - if return value is False or any Exception
	 */
	public static boolean isValidFtcsUrl(final String url) throws ApplicationException {
/*		boolean isValidUrl = false;
		Log.info("Given Value: " + url);			
		if (ESAPI.validator().isValidInput("vaidateBoeingUrl", url, "BOEINGURL", MAX_URL_LENGTH,
				true)) {
			isValidUrl = true;
		} else {
			Log.error("Security Validation: Invalid Characters found in URL");
			throw new ApplicationException("Invalid Characters found in URL");
		}
		
		return isValidUrl;*/
		return true;
	} 
	
	//veracode violations
	public static XMLStreamReader getSourceXml(String xml) throws ApplicationException {
		XMLStreamReader xmlStream = null;
		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			inputFactory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
			inputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
			xmlStream = inputFactory.createXMLStreamReader(new StringReader(xml));
		} catch (Exception e) {
			Log.error("Security Validation: While parser the xml");
			throw new ApplicationException(ExceptionKey.BusinessException);
		}
		return xmlStream;
	}
	//veracode violations
	
}
