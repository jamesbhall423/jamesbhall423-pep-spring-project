package com.example.exception;

import org.springframework.http.HttpStatus;

public class SocialMediaException extends RuntimeException {
    private final HttpStatus status;
    public SocialMediaException(String message, HttpStatus status) {
        super(message);
        this.status=status;
    }
    
}
