package com.boeing.ps.innovationvenue.service.impl;

import java.util.Calendar;

import com.boeing.ps.innovationvenue.common.exception.ApplicationException;
import com.boeing.ps.innovationvenue.repository.UserRoleRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boeing.ps.innovationvenue.entity.UserProfile;
import com.boeing.ps.innovationvenue.entity.UserRoles;
import com.boeing.ps.innovationvenue.repository.UserProfileRepository;
import com.boeing.ps.innovationvenue.service.UserProfileService;
import com.boeing.ps.innovationvenue.valueobjects.UserProfileRequest;
import com.boeing.ps.innovationvenue.valueobjects.UserProfileResponse;

@Service
public class UserProfileServiceImpl extends UserProfileService {
	
	private static final int ROLE_ID = 10;
	private static final String ROLE_DESC = "GUEST";
	private static final String CREATED_BY = "SYSTEM";

	private static final Logger logger = LoggerFactory.getLogger(UserProfileServiceImpl.class);
	
	@Autowired
	UserProfileRepository userProfileRepo;

	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Override
	public boolean isUserExists(long bemsId) {
		return userProfileRepo.existsById(bemsId);
	}
	
	@Override
	public UserProfileResponse getRolesByUserId(UserProfileRequest userProfileReq) throws ApplicationException{
		
		UserProfile userProfileEntity = null;
		UserRoles userRoles = null;
		UserProfileResponse userProfileRes = null;
		
		try {
			boolean isUserExists = isUserExists(userProfileReq.getBemsId());
			logger.info("User Exists  "+ isUserExists);
			int roleId = userProfileReq.getRoleId();
			/** If block will get executed during logging in to the application **/
			if(roleId == 0) {
				if(isUserExists) {
					UserProfile userProfile= userProfileRepo.findByBemsId(userProfileReq.getBemsId());
					userProfileRes = new UserProfileResponse(userProfile.getUserRoles().getRoleId(),userProfile.getUserRoles().getRoleDesc(),userProfile.isPSEmployee());
				} else {
					userRoles = new UserRoles(ROLE_ID,ROLE_DESC, CREATED_BY, Calendar.getInstance().getTime());
					userProfileEntity = new UserProfile(userProfileReq.getBemsId(),userProfileReq.getUserName(),userProfileReq.getEmailAddress(),
							Calendar.getInstance().getTime(),CREATED_BY,userRoles,userProfileReq.getPsEmp());
					userProfileRepo.save(userProfileEntity);
					userProfileRes = new UserProfileResponse(userRoles.getRoleId(),ROLE_DESC,userProfileReq.getPsEmp());
				}
			} 
			/** Else will get executed when assigning the idea to SME **/
			else if (roleId == 5 || roleId == 10){
				UserProfile userProfile = userProfileRepo.findByBemsId(userProfileReq.getBemsId());
				userRoles = new UserRoles(roleId,userRoleRepository.findByRoleId(roleId).getRoleDesc(), CREATED_BY, Calendar.getInstance().getTime());
				if (!(userProfile != null && "ADMIN".equalsIgnoreCase(userProfile.getUserRoles().getRoleDesc()))) {
					userProfileEntity = new UserProfile(userProfileReq.getBemsId(),userProfileReq.getUserName(),userProfileReq.getEmailAddress(),
							Calendar.getInstance().getTime(),CREATED_BY,userRoles,userProfileReq.getPsEmp());
					userProfileRepo.save(userProfileEntity);
				}
				userProfileRes = new UserProfileResponse(userRoles.getRoleId(),userRoles.getRoleDesc(),userProfileReq.getPsEmp());
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new ApplicationException("Exception occured while saving user information to database");
		}
		return userProfileRes;
	}
}
