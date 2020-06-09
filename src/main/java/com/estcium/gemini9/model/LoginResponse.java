package com.estcium.gemini9.model;

import java.io.Serializable;

public class LoginResponse implements Serializable
{

    private final String jwttoken;
    private final String message;
    private final String role;

    public LoginResponse(String jwttoken,String message,String role) {
        this.jwttoken = jwttoken;
        this.message = message;
        this.role = role;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public String getMessage() {
        return message;
    }

    public String getRole() {
        return role;
    }
}