package com.boeing.ps.innovationvenue.valueobjects;

public class MailResponse {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    private String message;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


   public MailResponse(String message,String status) {
        this.message = message;
        this.status=status;

    }

    public MailResponse() {
    }
}
