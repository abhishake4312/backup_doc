package com.boeing.ps.innovationvenue.valueobjects;

import com.boeing.ps.innovationvenue.entity.Idea;

import java.util.List;

public class AllIdeaResponse {
    List<Idea> ideaList;
    String message;
    
    public AllIdeaResponse() {
    	
    }

    public AllIdeaResponse(List<Idea> ideaList, String message) {
        this.ideaList = ideaList;
        this.message = message;
    }

    public List<Idea> getIdeaList() {
        return ideaList;
    }

    public void setIdeaList(List<Idea> ideaList) {
        this.ideaList = ideaList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
