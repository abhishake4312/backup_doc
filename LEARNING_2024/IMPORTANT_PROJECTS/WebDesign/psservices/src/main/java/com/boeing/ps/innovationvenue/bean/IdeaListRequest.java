package com.boeing.ps.innovationvenue.bean;

import java.io.Serializable;

public class IdeaListRequest implements Serializable {
    private long bemsId;
    private int status;

    public IdeaListRequest() {
    }

    public IdeaListRequest(long bemsId, int status) {
        this.bemsId = bemsId;
        this.status = status;
    }

    public long getBemsId() {
        return bemsId;
    }

    public void setBemsId(long bemsId) {
        this.bemsId = bemsId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
