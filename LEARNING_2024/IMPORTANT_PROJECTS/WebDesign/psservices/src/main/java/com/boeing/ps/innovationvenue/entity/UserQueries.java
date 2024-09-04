package com.boeing.ps.innovationvenue.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "user_queries")
public class UserQueries {

	@Id
	@GeneratedValue(generator = "SEQ_THREAD_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_THREAD_ID", sequenceName = "INNOVATION_USER_QUERIES_SEQ")
	@Column(name="thread_id")
	private long threadId;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="bems_id")
    @OnDelete(action=OnDeleteAction.CASCADE)
	private UserProfile user;
	
	@Column(name="subject")
	private String subject;
	
	@Lob
	@Column(name="message_content")
	private String messageBody;
	
	@Column(name="created_Date")
	private Date createdDate;

	public UserQueries() {
		
	}
	
	public UserQueries(UserProfile user, String subject, String messageBody, Date createdDate) {
		this.user = user;
		this.subject = subject;
		this.messageBody = messageBody;
		this.createdDate = createdDate;
	}

	public long getThreadId() {
		return threadId;
	}

	public void setThreadId(long threadId) {
		this.threadId = threadId;
	}

	public UserProfile getUser() {
		return user;
	}

	public void setBemsId(UserProfile user) {
		this.user = user;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}	
}
