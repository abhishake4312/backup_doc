package com.boeing.ps.innovationvenue.valueobjects;

import java.util.Date;

import com.boeing.ps.innovationvenue.entity.UserRoles;

public class IdeaAssigneeResponse {

	private long assigneeId;
	private UserInfo userInfo;
	
	public IdeaAssigneeResponse() {
		
	}
	
	public IdeaAssigneeResponse(long assigneeId, UserInfo userInfo) {
		super();
		this.assigneeId = assigneeId;
		this.userInfo = userInfo;
	}
	public long getAssigneeId() {
		return assigneeId;
	}
	public void setAssigneeId(long assigneeId) {
		this.assigneeId = assigneeId;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
}
