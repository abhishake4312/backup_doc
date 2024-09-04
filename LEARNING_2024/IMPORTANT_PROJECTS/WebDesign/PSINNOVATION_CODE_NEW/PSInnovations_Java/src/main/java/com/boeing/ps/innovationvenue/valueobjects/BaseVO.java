
package com.boeing.ps.innovationvenue.valueobjects;

import java.io.Serializable;

public class BaseVO implements Serializable {

	private static final long serialVersionUID = -3561313310836146976L;

	private String status;// Success/Failure
	private String statusMessage;


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}
