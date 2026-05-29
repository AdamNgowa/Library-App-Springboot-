package com.masha.libraryapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

//This is a global exception handler
@RestControllerAdvice
 public class GlobalExceptionHandler {
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleNotFound(BookNotFoundException ex){
        return new ResponseEntity<>(
                Map.of("error",ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}