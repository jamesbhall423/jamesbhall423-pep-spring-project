package com.example.exception;

import org.springframework.http.HttpStatus;

public class InvalidAccountException extends SocialMediaException {
    public InvalidAccountException(String message) {
        super(message,HttpStatus.BAD_REQUEST);
    }
}
