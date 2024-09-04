package com.boeing.ps.innovationvenue.bean;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailConfig {

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private int port;


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
    public int getPort() {
        return port;
    }

    public void setPort(int port) {

        this.port = port;
    }

}
