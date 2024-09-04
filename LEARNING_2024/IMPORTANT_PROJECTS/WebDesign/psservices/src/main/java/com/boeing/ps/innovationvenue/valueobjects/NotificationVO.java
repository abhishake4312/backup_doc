package com.boeing.ps.innovationvenue.valueobjects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class NotificationVO extends BaseVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2351995342675633491L;

	private BigDecimal notificationID;

	private String notificationMessage;

	private long bemsId;
	// 0-Not read 1-Read
	private int readStatus;
	// Common to all  
	private int isPublic;
	private Date createdDate;

	/**
	 * @return the notificationID
	 */
	public BigDecimal getNotificationID() {
		return notificationID;
	}

	/**
	 * @param notificationID the notificationID to set
	 */
	public void setNotificationID(BigDecimal notificationID) {
		this.notificationID = notificationID;
	}

	/**
	 * @return the notificationMessage
	 */
	public String getNotificationMessage() {
		return notificationMessage;
	}

	/**
	 * @param notificationMessage the notificationMessage to set
	 */
	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}

	/**
	 * @return the bemsId
	 */
	public long getBemsId() {
		return bemsId;
	}

	/**
	 * @param bemsId the bemsId to set
	 */
	public void setBemsId(long bemsId) {
		this.bemsId = bemsId;
	}




	/**
	 * @return the isPublic
	 */
	public int getIsPublic() {
		return isPublic;
	}

	/**
	 * @param isPublic the isPublic to set
	 */
	public void setIsPublic(int isPublic) {
		this.isPublic = isPublic;
	}

	public int getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(int readStatus) {
		this.readStatus = readStatus;
	}

	public NotificationVO(BigDecimal notificationID, String notificationMessage, long bemsId, int readStatu,
			int isPublic) {
		super();
		this.notificationID = notificationID;
		this.notificationMessage = notificationMessage;
		this.bemsId = bemsId;
		this.readStatus=readStatu;
		this.isPublic = isPublic;
	}

	/**
	 * @param notificationMessage
	 * @param bemsId
	 * @param status
	 * @param isPublic
	 */
	public NotificationVO(String notificationMessage, long bemsId, int readStatu, int isPublic) {
		super();
		this.notificationMessage = notificationMessage;
		this.bemsId = bemsId;
		this.readStatus=readStatu;
		this.isPublic = isPublic;
	}

	public NotificationVO() {
		

	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @param notificationID
	 * @param notificationMessage
	 * @param bemsId
	 * @param readStatus
	 * @param isPublic
	 * @param createdDate
	 */
	public NotificationVO(BigDecimal notificationID, String notificationMessage, long bemsId, int readStatus,
			int isPublic, Date createdDate) {
		super();
		this.notificationID = notificationID;
		this.notificationMessage = notificationMessage;
		this.bemsId = bemsId;
		this.readStatus = readStatus;
		this.isPublic = isPublic;
		this.createdDate = createdDate;
	}

}
