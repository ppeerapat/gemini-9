package com.estcium.gemini9.model;

import java.io.Serializable;

public class LoginResponse implements Serializable
{

    private final String jwttoken;
    private final String message;

    public LoginResponse(String jwttoken,String message) {
        this.jwttoken = jwttoken;
        this.message = message;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public String getMessage() {
        return message;
    }
}