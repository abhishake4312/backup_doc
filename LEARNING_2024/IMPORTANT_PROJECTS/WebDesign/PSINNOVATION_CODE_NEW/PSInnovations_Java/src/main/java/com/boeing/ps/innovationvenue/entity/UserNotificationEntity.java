package com.boeing.ps.innovationvenue.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "USER_NOTIFICATION")

public class UserNotificationEntity {

	@Id
	@Column(name = "NOTIFICATION_ID")
	@GenericGenerator(name = "seqGen", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence_name", value = "USER_NOTIFICATION_SEQ"),
			@org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
	@GeneratedValue(generator = "seqGen")
	private BigDecimal notificationID;

	@Column(name = "NOTIFICATION_MESSAGE")
	private String notificationMessage;

	@Column(name = "CREATED_ON")
	private Date createdDate;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BEMS_ID")
	private UserProfile userProfile;

	@Column(name = "STATUS")
	private int status; 
	
	@Column(name = "IS_PUBLIC")
	private int isPublic;

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
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the users
	 */
	public UserProfile getUsers() {
		return userProfile;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(UserProfile users) {
		this.userProfile = users;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
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

	public UserNotificationEntity(String notificationMessage, Date createdDate, String createdBy, UserProfile users,
			int status, int isPublic) {
		super();
		this.notificationMessage = notificationMessage;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.userProfile = users;
		this.status = status;
		this.isPublic = isPublic;
	}

	public UserNotificationEntity() {
		// TODO Auto-generated constructor stub
	}
}
