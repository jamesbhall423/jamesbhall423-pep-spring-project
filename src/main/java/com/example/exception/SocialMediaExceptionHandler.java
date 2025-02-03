package com.example.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class SocialMediaExceptionHandler {
    
    @ExceptionHandler(SocialMediaException.class)
    public ResponseEntity<String> handleException(SocialMediaException e) {
        return ResponseEntity.status(e.geHttpStatus()).body(e.getMessage());
    }
}
