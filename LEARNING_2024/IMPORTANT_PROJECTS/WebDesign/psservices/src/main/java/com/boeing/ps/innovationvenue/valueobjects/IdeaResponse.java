package com.boeing.ps.innovationvenue.valueobjects;

import com.boeing.ps.innovationvenue.entity.Idea;

import java.io.Serializable;

public class IdeaResponse implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int ideaId;
    private String message;



    public IdeaResponse(){

    }
    public IdeaResponse(int ideaId, String message) {
        this.ideaId = ideaId;
        this.message = message;
    }

    public int getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(int ideaId) {
        this.ideaId = ideaId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}



