package com.boeing.ps.innovationvenue.valueobjects;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.boeing.ps.innovationvenue.customvalidator.UserRoleConstraint;

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

	@NotNull(message="Employee type can't be null")
	@NotEmpty
	private String psEmp;

	@NotNull(message="Role id can't be null")
	@UserRoleConstraint
	private int roleId;

	public UserProfileRequest() {
		
	}
	
	public UserProfileRequest(long bemsId, String userName, String emailAddress, String psEmp, int roleId) {
		this.bemsId = bemsId;
		this.userName = userName;
		this.emailAddress = emailAddress;
		this.psEmp = psEmp;
		this.roleId = roleId;
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

	public String getPsEmp() {
		return psEmp;
	}

	public void setPsEmp(String psEmp) {
		this.psEmp = psEmp;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
