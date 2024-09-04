package com.boeing.ps.innovationvenue.valueobjects;

import java.util.List;

public class IdeaResponseForAdmin {
	    List<IdeasResponse> ideaList;
	    String message;
	    
	    public IdeaResponseForAdmin() {
	    	
	    }

	    public IdeaResponseForAdmin(List<IdeasResponse> ideaList, String message) {
	        this.ideaList = ideaList;
	        this.message = message;
	    }

	    public List<IdeasResponse> getIdeaList() {
	        return ideaList;
	    }

	    public void setIdeaList(List<IdeasResponse> ideaList) {
	        this.ideaList = ideaList;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }
}
