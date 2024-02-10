package com.vicrum.books.gradleGroovy.java21.exeption;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<SingleErrorResponse> processingException(EntityNotFoundException e) {
        SingleErrorResponse response = new SingleErrorResponse();
        response.setLogref("error");
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<SingleErrorResponse> processingException(NoSuchElementException e) {
        SingleErrorResponse response = new SingleErrorResponse();
        response.setLogref("error");
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

