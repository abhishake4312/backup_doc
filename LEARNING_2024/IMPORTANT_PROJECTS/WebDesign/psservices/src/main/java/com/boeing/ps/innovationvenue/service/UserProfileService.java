package com.boeing.ps.innovationvenue.service;

import org.springframework.stereotype.Service;

import com.boeing.ps.innovationvenue.common.exception.ApplicationException;
import com.boeing.ps.innovationvenue.valueobjects.UserProfileRequest;
import com.boeing.ps.innovationvenue.valueobjects.UserProfileResponse;

@Service
public abstract class UserProfileService {
	
	public abstract UserProfileResponse getRolesByUserId(UserProfileRequest userProfileReq) throws ApplicationException;
	
	public abstract boolean isUserExists(long bemsId);
}
