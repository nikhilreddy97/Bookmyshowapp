package com.online.movieticketbookingapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, value = HttpStatus.BAD_REQUEST, reason = "Booking Details Not Saved")
public class BookingDetailsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BookingDetailsException(String message) {
        super(message);
    }
}

