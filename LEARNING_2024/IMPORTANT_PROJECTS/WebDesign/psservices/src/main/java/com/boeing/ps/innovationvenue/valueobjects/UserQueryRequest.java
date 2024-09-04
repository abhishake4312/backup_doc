package com.boeing.ps.innovationvenue.valueobjects;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserQueryRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6486624893881100974L;

	@NotNull(message="BemsId can't be null")
	@Min(1)
	private long bemsId;
	
	@NotNull(message="Message can't be null")
	@NotEmpty
	private String messageBody;
	
	@NotNull(message="Subject can't be null")
	@NotEmpty
	private String subject;

	public UserQueryRequest() {
		
	}
	
	public long getBemsId() {
		return bemsId;
	}

	public void setBemsId(long bemsId) {
		this.bemsId = bemsId;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}	
}
