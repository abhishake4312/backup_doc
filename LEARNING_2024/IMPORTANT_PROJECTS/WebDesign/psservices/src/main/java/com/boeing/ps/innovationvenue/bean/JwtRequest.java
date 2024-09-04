package com.boeing.ps.innovationvenue.bean;

import java.io.Serializable;

public class JwtRequest implements Serializable {
    private String bemsId;
    private String emailId;

    public JwtRequest()
    {

    }

    public JwtRequest(String bemsId, String emailId) {
        this.bemsId = bemsId;
        this.emailId = emailId;
    }

    public String getBemsId() {
        return bemsId;
    }

    public void setBemsId(String bemsId) {
        this.bemsId = bemsId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
