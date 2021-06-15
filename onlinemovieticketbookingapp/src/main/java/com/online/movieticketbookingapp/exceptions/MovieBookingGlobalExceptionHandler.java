package com.online.movieticketbookingapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class MovieBookingGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
        return new ResponseEntity<String>("No Value is present in DB, Please change your request", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException) {
        return new ResponseEntity<String>("Please change the request Method type", HttpStatus.BAD_REQUEST);
    }
}
