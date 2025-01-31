package com.example.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends SocialMediaException {
    public UnauthorizedException(String message) {
        super(message,HttpStatus.UNAUTHORIZED);
    }
}
