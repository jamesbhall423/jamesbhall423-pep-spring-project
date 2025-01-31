package com.example.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends SocialMediaException {
    public ConflictException(String message) {
        super(message,HttpStatus.CONFLICT);
    }
}
