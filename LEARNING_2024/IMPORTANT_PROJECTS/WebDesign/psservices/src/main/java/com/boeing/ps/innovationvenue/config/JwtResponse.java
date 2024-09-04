package com.boeing.ps.innovationvenue.config;

import java.io.Serializable;

public class JwtResponse implements Serializable {
    private final String response;

    public JwtResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return this.response;
    }

}
