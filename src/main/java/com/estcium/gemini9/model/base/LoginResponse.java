package com.estcium.gemini9.model.base;

import com.estcium.gemini9.model.User;

import java.io.Serializable;

public class LoginResponse implements Serializable
{

    private final String jwttoken;
    private final String message;
    private final User user;

    public LoginResponse(String jwttoken,String message,User u) {
        this.jwttoken = jwttoken;
        this.message = message;
        this.user = u;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}