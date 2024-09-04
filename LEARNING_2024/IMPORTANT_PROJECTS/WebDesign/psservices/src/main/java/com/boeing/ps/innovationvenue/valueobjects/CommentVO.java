
package com.boeing.ps.innovationvenue.valueobjects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CommentVO extends BaseVO implements Serializable {

	private BigDecimal commentID;

	private BigDecimal contentID;

	private BigDecimal parentComentID;

	private String description;

	private BigDecimal commentingUser;

	private Date createdDate;


	public CommentVO() {

	}

	/**
	 * @param commentID
	 * @param contentID
	 * @param parentComentID
	 * @param description
	 * @param commentingUser
	 */
	public CommentVO(BigDecimal commentID, BigDecimal contentID, BigDecimal parentComentID, String description,
			BigDecimal commentingUser) {
		super();
		this.commentID = commentID;
		this.contentID = contentID;
		this.parentComentID = parentComentID;
		this.description = description;
		this.commentingUser = commentingUser;
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
	 * @return the contentID
	 */
	public BigDecimal getContentID() {
		return contentID;
	}

	/**
	 * @param contentID the contentID to set
	 */
	public void setContentID(BigDecimal contentID) {
		this.contentID = contentID;
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
	 * @return the commentingUser
	 */
	public BigDecimal getCommentingUser() {
		return commentingUser;
	}

	/**
	 * @param commentingUser the commentingUser to set
	 */
	public void setCommentingUser(BigDecimal commentingUser) {
		this.commentingUser = commentingUser;
	}

	/**
	 * @return the createdDate
	 */

	public Date getCreatedDate() { return createdDate; }

	/**
	 * @param  createdDate the createdDate to set
	 */

	public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

}
