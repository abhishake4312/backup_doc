package com.boeing.ps.innovationvenue.valueobjects;

import java.io.Serializable;

public class UserProfileResponse extends BaseVO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int roleId;
	private String roleDesc;
	
	public UserProfileResponse() {
		
	}

	public UserProfileResponse(int roleId, String roleDesc) {
		this.roleId = roleId;
		this.roleDesc = roleDesc;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
}
