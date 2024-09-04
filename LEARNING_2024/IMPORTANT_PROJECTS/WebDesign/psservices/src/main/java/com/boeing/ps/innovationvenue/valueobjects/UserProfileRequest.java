package com.boeing.ps.innovationvenue.valueobjects;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserProfileRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull(message="Bems Id can't be null")
	@Min(1)
	private long bemsId;
	
	@NotNull(message="Username can't be null")
	@NotEmpty
	private String userName;
	
	@NotNull(message="Email Address can't be null")
	@NotEmpty
	private String emailAddress;
	
	public UserProfileRequest() {
		
	}
	
	public UserProfileRequest(long bemsId, String userName, String emailAddress) {
		this.bemsId = bemsId;
		this.userName = userName;
		this.emailAddress = emailAddress;
	}
	
	public long getBemsId() {
		return bemsId;
	}
	public void setBemsId(long bemsId) {
		this.bemsId = bemsId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
