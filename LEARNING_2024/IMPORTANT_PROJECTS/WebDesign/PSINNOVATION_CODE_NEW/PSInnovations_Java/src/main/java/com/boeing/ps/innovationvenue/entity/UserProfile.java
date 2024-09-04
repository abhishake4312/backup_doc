package com.boeing.ps.innovationvenue.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "user_profile")
public class UserProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="bems_id")
	private long bemsId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="email_address")
	private String emailAddress;
	
	@Temporal(TemporalType.DATE)
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "role_id")
	private UserRoles userRoles;

	@Column(name="is_ps_emp")
	private String isPSEmployee;

//    @OneToMany(cascade = {CascadeType.ALL})
//	@JoinTable(name="user_idea",joinColumns=@JoinColumn(name="bems_id"),
//	            inverseJoinColumns=@JoinColumn(name="idea_id")
//	)
//	private List<Idea> ideaList;

//	@OneToMany(cascade = {CascadeType.ALL},mappedBy = "user")
//	private List<Idea> ideaList;

	public UserProfile() {


	}

	public UserProfile(long bemsId, String userName, String emailAddress, Date createdDate, String createdBy,UserRoles userRoles, String isPSEmployee) {
		this.bemsId = bemsId;
		this.userName = userName;
		this.emailAddress = emailAddress;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.userRoles = userRoles;
		this.isPSEmployee = isPSEmployee;
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

//	public List<Idea> getIdeaList() {
//		return ideaList;
//	}
//
//	public void setIdeaList(List<Idea> ideaList) {
//		this.ideaList = ideaList;
//	}


	public String isPSEmployee() {
		return isPSEmployee;
	}

	public void setPSEmployee(String isPSEmployee) {
		isPSEmployee = isPSEmployee;
	}
}
