package com.cognixia.jump.languagelearning.model;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String jwt;

    public AuthenticationResponse(String jwt){
        this.jwt = jwt;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
    
}
