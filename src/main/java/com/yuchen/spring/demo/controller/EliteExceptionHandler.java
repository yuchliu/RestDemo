package com.yuchen.spring.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EliteExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EliteErrorMessage> handleEliteNotFoundException (EliteNotFoundException e) {
        EliteErrorMessage errorMessage = new EliteErrorMessage();

        errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
        errorMessage.setMessage(e.getMessage());
        errorMessage.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EliteErrorMessage> handleGeneralException (Exception e) {
        EliteErrorMessage errorMessage = new EliteErrorMessage();

        errorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
        errorMessage.setMessage(e.getMessage());
        errorMessage.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
