package com.example.exception;

import org.springframework.http.HttpStatus;

public class InvalidMessageException extends SocialMediaException {
    public InvalidMessageException(String message) {
        super(message,HttpStatus.BAD_REQUEST);
    }
}
