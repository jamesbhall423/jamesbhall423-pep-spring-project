package com.example.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class SocialMediaExceptionHandler {
    
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<String> handleException(ConflictException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
    @ExceptionHandler(InvalidAccountException.class)
    public ResponseEntity<String> handleException(InvalidAccountException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
