package com.boeing.ps.innovationvenue.valueobjects;

import java.io.Serializable;

public class AdminAllIdea implements Serializable {
    private int ideaId;
    private String ideaTitle;
    private String ideaBody;
    private int ideaStatus;
    private String submittedDate;
    private String modificationDate;
    private long bemsId;

    public AdminAllIdea() {

    }

    public AdminAllIdea(int ideaId, String ideaTitle, String ideaBody, int ideaStatus, String submittedDate, String modificationDate, long bemsId) {
        this.ideaId = ideaId;
        this.ideaTitle = ideaTitle;
        this.ideaBody = ideaBody;
        this.ideaStatus = ideaStatus;
        this.submittedDate = submittedDate;
        this.modificationDate = modificationDate;
        this.bemsId = bemsId;
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

    public long getBemsId() {
        return bemsId;
    }

    public void setBemsId(long bemsId) {
        this.bemsId = bemsId;
    }

    public String getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(String submittedDate) {
        this.submittedDate = submittedDate;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    @Override
    public String toString() {
        return "AdminAllIdea{" +
                "ideaId=" + ideaId +
                ", ideaTitle='" + ideaTitle + '\'' +
                ", ideaBody='" + ideaBody + '\'' +
                ", ideaStatus=" + ideaStatus +
                ", submittedDate=" + submittedDate +
                ", modificationDate=" + modificationDate +
                ", bemsId=" + bemsId +
                '}';
    }
}
