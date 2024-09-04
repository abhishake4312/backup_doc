package com.boeing.ps.innovationvenue.valueobjects;

import java.util.Date;

import com.boeing.ps.innovationvenue.entity.UserRoles;

public class UserInfo {

	private long bemsId;
	private String userName;
	private String emailAddress;
	private Date createdDate;
	private String createdBy;
	private UserRoles userRoles;
	
	public UserInfo() {
		
	}
	
	public UserInfo(long bemsId, String userName, String emailAddress, Date createdDate, String createdBy, UserRoles userRoles) {
		this.bemsId = bemsId;
		this.userName = userName;
		this.emailAddress = emailAddress;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.userRoles = userRoles;
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
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public UserRoles getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(UserRoles userRoles) {
		this.userRoles = userRoles;
	}
}
