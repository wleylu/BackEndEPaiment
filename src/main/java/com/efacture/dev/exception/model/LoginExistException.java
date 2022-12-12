package com.efacture.dev.exception.model;

@SuppressWarnings("serial")
public class LoginExistException extends Exception {
    public LoginExistException(String message) {
        super(message);
    }
}
