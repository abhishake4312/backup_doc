package com.boeing.ps.innovationvenue.entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Component
@Entity
@Table(name = "idea_table")
public class Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idea_id", unique = true, nullable = false)
    private int ideaId;

    @Column(name = "idea_title")
    private String ideaTitle;

    @Lob
    @Column(name = "idea_body")
    private String ideaBody;

    @Column(name = "idea_status")
    private int ideaStatus;

    @Column(name = "submitted_date")
    private Date submittedDate;

    @Column(name = "modification_date")
    private Date modificationDate;

    @ManyToOne()
    @JoinColumn(name="bems_id")
    private UserProfile user;
    
    @JsonManagedReference
    @OneToOne(mappedBy = "idea")
    private IdeaAssignee ideaAssigee; 

    public Idea(){

    }

    public Idea( String ideaTitle,String ideaBody, int ideaStatus, Date modificationDate,UserProfile userProfile) {
        this.ideaTitle = ideaTitle;
        this.ideaBody = ideaBody;
        this.ideaStatus = ideaStatus;
        this.modificationDate = modificationDate;
        this.user =userProfile;

    }

    public int getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(int ideaId) {
        this.ideaId = ideaId;
    }

    public String getIdeaTitle() {
        return ideaTitle;
    }

    public void setIdeaTitle(String ideaTitle) {
        this.ideaTitle = ideaTitle;
    }


    public String getIdeaBody() {
        return ideaBody;
    }

    public void setIdeaBody(String ideaBody) {
        this.ideaBody = ideaBody;
    }

    public int getIdeaStatus() {
        return ideaStatus;
    }

    public void setIdeaStatus(int ideaStatus) {
        this.ideaStatus = ideaStatus;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public UserProfile getUser() {
        return user;
    }

    public void setUser(UserProfile user) {
        this.user = user;
    }

	public IdeaAssignee getIdeaAssigee() {
		return ideaAssigee;
	}

	public void setIdeaAssigee(IdeaAssignee ideaAssigee) {
		this.ideaAssigee = ideaAssigee;
	}
}