package com.boeing.ps.innovationvenue.valueobjects;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class IdeaStatusRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Bems Id can't be null")
	private long bemsId;
	
	@NotNull(message = "Idea Id can't be null")
    private int ideaId;
	
	@NotNull(message = "Status can't be null")
	@Min(3)
	@Max(5)
    private int ideaStatus;

    public IdeaStatusRequest(long bemsId, int ideaId, int ideaStatus) {
    	this.bemsId = bemsId;
        this.ideaId = ideaId;
        this.ideaStatus = ideaStatus;
    }

    public IdeaStatusRequest(){

    }

    public long getBemsId() {
		return bemsId;
	}

	public void setBemsId(long bemsId) {
		this.bemsId = bemsId;
	}

	public int getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(int ideaId) {
        this.ideaId = ideaId;
    }

    public int getIdeaStatus() {
        return ideaStatus;
    }

    public void setIdeaStatus(int ideaStatus) {
        this.ideaStatus = ideaStatus;
    }
}
