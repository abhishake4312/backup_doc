package com.boeing.ps.innovationvenue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Component
@Entity
@Table(name = "idea_assignee")
public class IdeaAssignee {
	
	@Id
	@GeneratedValue(generator = "SEQ_THREAD_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_THREAD_ID", sequenceName = "IDEA_ASSIGNEE_SEQ")
	@Column(name="id")
	private long id;

    @Column(name = "assignee_id")
    private long assigneeId;
    
    @JsonBackReference
    @OneToOne
	@JoinColumn(name = "idea_id")
	private Idea idea;
    
    @Column(name="status_flag")
    private String statusFlag;

    public IdeaAssignee() {
    	
    }
    
	public IdeaAssignee(long assigneeId, Idea idea, String statusFlag) {
		this.assigneeId = assigneeId;
		this.idea = idea;
		this.statusFlag = statusFlag;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAssigneeId() {
		return assigneeId;
	}

	public void setAssigneeId(long assigneeId) {
		this.assigneeId = assigneeId;
	}

	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	public String getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(String statusFlag) {
		this.statusFlag = statusFlag;
	}
}