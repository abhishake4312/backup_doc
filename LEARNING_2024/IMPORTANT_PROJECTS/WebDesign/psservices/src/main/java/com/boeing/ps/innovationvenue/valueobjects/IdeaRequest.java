package com.boeing.ps.innovationvenue.valueobjects;

import java.io.Serializable;
import java.sql.Clob;

public class IdeaRequest implements Serializable {


    private static final long serialVersionUID = 1L;


    private int ideaId;
    private long bemsId;
    private String ideaTitle;
    private int ideaStatus;
    private String ideaBody;


    public IdeaRequest(){

    }

    public IdeaRequest(long bemsId, String ideaTitle, String ideaDescription, int ideaStatus, String ideaBody) {
        this.bemsId = bemsId;
        this.ideaTitle = ideaTitle;

        this.ideaStatus = ideaStatus;
        this.ideaBody = ideaBody;

    }



    public long getBemsId() {
        return bemsId;
    }

    public void setBemsId(long bemsId) {
        this.bemsId = bemsId;
    }

    public String getIdeaTitle() {
        return ideaTitle;
    }

    public void setIdeaTitle(String ideaTitle) {
        this.ideaTitle = ideaTitle;
    }

    public int getIdeaStatus() {
        return ideaStatus;
    }

    public void setIdeaStatus(int ideaStatus) {
        this.ideaStatus = ideaStatus;
    }

    public String getIdeaBody() {
        return ideaBody;
    }

    public void setIdeaBody(String ideaBody) {
        this.ideaBody = ideaBody;
    }

    public int getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(int ideaId) {
        this.ideaId = ideaId;
    }




}
