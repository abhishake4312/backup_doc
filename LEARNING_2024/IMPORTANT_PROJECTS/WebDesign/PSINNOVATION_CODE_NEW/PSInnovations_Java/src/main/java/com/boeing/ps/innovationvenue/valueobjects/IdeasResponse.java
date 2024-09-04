package com.boeing.ps.innovationvenue.valueobjects;

import java.util.Date;

public class IdeasResponse {

	private int ideaId;
	private String ideaTitle;
	private String ideaBody;
	private int ideaStatus;
	private Date submittedDate;
	private Date modificationDate;
	private UserInfo user;
	private IdeaAssigneeResponse ideaAssignee;
	
	public IdeasResponse() {
		
	}
	
	public IdeasResponse(int ideaId, String ideaTitle, String ideaBody, int ideaStatus, Date submittedDate,
			Date modificationDate, UserInfo user, IdeaAssigneeResponse ideaAssignee) {
		this.ideaId = ideaId;
		this.ideaTitle = ideaTitle;
		this.ideaBody = ideaBody;
		this.ideaStatus = ideaStatus;
		this.submittedDate = submittedDate;
		this.modificationDate = modificationDate;
		this.user = user;
		this.ideaAssignee = ideaAssignee;
	}
	public int getIdeaId() {
		return ideaId;
	}
	public void setIdeaId(int ideaId) {
		this.ideaId = ideaId;
	}
	public String getIdeaTitle() {
		return ideaTitle;
	}
	public void setIdeaTitle(String ideaTitle) {
		this.ideaTitle = ideaTitle;
	}
	public String getIdeaBody() {
		return ideaBody;
	}
	public void setIdeaBody(String ideaBody) {
		this.ideaBody = ideaBody;
	}
	public int getIdeaStatus() {
		return ideaStatus;
	}
	public void setIdeaStatus(int ideaStatus) {
		this.ideaStatus = ideaStatus;
	}
	public Date getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public IdeaAssigneeResponse getIdeaAssignee() {
		return ideaAssignee;
	}

	public void setIdeaAssignee(IdeaAssigneeResponse ideaAssignee) {
		this.ideaAssignee = ideaAssignee;
	}
}
