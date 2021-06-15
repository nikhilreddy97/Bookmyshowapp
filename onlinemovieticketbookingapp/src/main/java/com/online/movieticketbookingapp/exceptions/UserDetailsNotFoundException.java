package com.online.movieticketbookingapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, value = HttpStatus.NOT_FOUND, reason = "User Details Not Found")
public class UserDetailsNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserDetailsNotFoundException(String message) {
        super(message);
    }
}
