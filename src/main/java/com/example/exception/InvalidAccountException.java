package com.example.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class InvalidAccountException extends SocialMediaException {
    public InvalidAccountException(String message) {
        super(message,HttpStatus.BAD_REQUEST);
    }
}
