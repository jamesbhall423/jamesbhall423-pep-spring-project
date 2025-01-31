package com.example.exception;

public class UnauthorizedException extends SecurityException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
