package com.boeing.ps.innovationvenue.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "user_roles")
public class UserRoles implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	private int roleId;
	
	@Column(name="role_desc")
	private String roleDesc;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_date")
	private Date createdDate;
	


	public UserRoles() {
		
	}
	
	public UserRoles( int roleId,String roleDesc, String createdBy, Date createdDate) {
		this.roleId=roleId;
		this.roleDesc = roleDesc;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}	
}
