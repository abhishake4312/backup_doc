package com.boeing.ps.innovationvenue.valueobjects;

import java.io.Serializable;
import java.util.List;

import com.boeing.ps.innovationvenue.entity.Idea;

public class AdminAllIdeaResponse implements Serializable {
    List<Idea> ideaList;
    String message;

    public AdminAllIdeaResponse() {

    }

    public AdminAllIdeaResponse(List<Idea> ideaList, String message) {
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
