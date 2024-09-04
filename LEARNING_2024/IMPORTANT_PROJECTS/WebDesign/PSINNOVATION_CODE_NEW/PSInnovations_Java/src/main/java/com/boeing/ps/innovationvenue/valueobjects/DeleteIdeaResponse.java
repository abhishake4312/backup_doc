package com.boeing.ps.innovationvenue.valueobjects;

import java.io.Serializable;

public class DeleteIdeaResponse extends BaseVO implements Serializable
{
    private int idea;

    public int getIdea() {
        return idea;
    }

    public void setIdea(int idea) {
        this.idea = idea;
    }
}
