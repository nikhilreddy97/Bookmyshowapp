package com.online.movieticketbookingapp.service;

import com.online.movieticketbookingapp.entity.Booking;

public interface BookingService {
    Booking seatBooking(Booking booking) throws Exception;
}
