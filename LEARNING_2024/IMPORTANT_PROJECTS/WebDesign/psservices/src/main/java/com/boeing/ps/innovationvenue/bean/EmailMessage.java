package com.boeing.ps.innovationvenue.bean;


import java.util.ArrayList;

public class EmailMessage {

    public EmailMessage() {
    }

    public EmailMessage(String messageBody, ArrayList<String> toAddress, String subject, 
    				String fromAddress, String ccAddress, long bemsId){
        this.messageBody=messageBody;
        this.toAddress=toAddress;
        this.subject=subject;
        this.fromAddress=fromAddress;
        this.bemsId=bemsId;
        this.ccAddress=ccAddress;
    }
    private String messageBody;

    private ArrayList<String> toAddress;
    private String subject;
    private String fromAddress;
    private long bemsId;
    private String ccAddress;
   
    public ArrayList<String> getToAddress() {
        return toAddress;
    }

    public void setToAddress(ArrayList<String> toAddress) {
        this.toAddress = toAddress;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }


    public long getBemsId() {
        return bemsId;
    }
    
    public void setBemsId(long bemsId) {
    	this.bemsId = bemsId;
    }

	public String getCcAddress() {
		return ccAddress;
	}

	public void setCcAddress(String ccAddress) {
		this.ccAddress = ccAddress;
	}
}
