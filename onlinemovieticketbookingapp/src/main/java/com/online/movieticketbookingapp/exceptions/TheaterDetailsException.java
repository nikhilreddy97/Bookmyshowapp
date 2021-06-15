package com.online.movieticketbookingapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, value = HttpStatus.NOT_FOUND, reason = "Theater Details Not Found")
public class TheaterDetailsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TheaterDetailsException(String message) {
        super(message);
    }
}