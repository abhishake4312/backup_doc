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
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "INNOVATION_IDEA_COMMENTS")
public class IdeaCommentEntity {

	@Id
	@Column(name = "COMMENT_ID")
	@GenericGenerator(name = "seqGen", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence_name", value = "INNOVATION_IDEA_COMMENT_SEQ"),
			@org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
	@GeneratedValue(generator = "seqGen")
	private BigDecimal commentID;

	@Column(name = "PARENT_COMMENT_ID")
	private BigDecimal parentComentID;

	@Type(type = "org.hibernate.type.MaterializedClobType")
	@Column(name = "COMMENT_DESCRIPTION")
	private String description;

	@Column(name = "CREATED_ON")
	private Date createdDate;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BEMS_ID")
	private UserProfile users;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "IDEA_ID")
	private Idea idea;

	public IdeaCommentEntity() {

	}

	/**
	 * @return the commentID
	 */
	public BigDecimal getCommentID() {
		return commentID;
	}

	/**
	 * @param commentID the commentID to set
	 */
	public void setCommentID(BigDecimal commentID) {
		this.commentID = commentID;
	}

	/**
	 * @return the parentComentID
	 */
	public BigDecimal getParentComentID() {
		return parentComentID;
	}

	/**
	 * @param parentComentID the parentComentID to set
	 */
	public void setParentComentID(BigDecimal parentComentID) {
		this.parentComentID = parentComentID;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(UserProfile users) {
		this.users = users;
	}

	/**
	 * @return the idea
	 */
	public Idea getIdea() {
		return idea;
	}

	/**
	 * @param idea the idea to set
	 */
	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	/**
	 * @param commentID
	 * @param parentComentID
	 * @param description
	 * @param createdDate
	 * @param createdBy
	 * @param users
	 * @param idea
	 */
	public IdeaCommentEntity(BigDecimal commentID, BigDecimal parentComentID, String description, Date createdDate,
			String createdBy, UserProfile users, Idea idea) {
		super();
		this.commentID = commentID;
		this.parentComentID = parentComentID;
		this.description = description;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.users = users;
		this.idea = idea;
	}

}
