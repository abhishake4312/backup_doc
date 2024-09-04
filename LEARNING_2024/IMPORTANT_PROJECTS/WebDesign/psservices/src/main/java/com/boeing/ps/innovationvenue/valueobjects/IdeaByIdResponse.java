package com.boeing.ps.innovationvenue.valueobjects;

import com.boeing.ps.innovationvenue.entity.Idea;

public class IdeaByIdResponse {
    private String message;
    private Idea idea;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Idea getIdea() {
        return idea;
    }

    public void setIdea(Idea idea) {
        this.idea = idea;
    }
}
