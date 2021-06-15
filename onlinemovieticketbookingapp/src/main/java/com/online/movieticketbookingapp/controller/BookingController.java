package com.online.movieticketbookingapp.controller;

import com.online.movieticketbookingapp.dto.BookingConfirmationDto;
import com.online.movieticketbookingapp.entity.BookedSeats;
import com.online.movieticketbookingapp.entity.Booking;
import com.online.movieticketbookingapp.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {

    @Autowired
    BookingService service;


    @PostMapping("/seat/booking")
    public ResponseEntity<BookingConfirmationDto> seatBooking(@RequestBody Booking booking) throws Exception {
        Booking bookingResponse = service.seatBooking(booking);
        BookingConfirmationDto bookingDto = new BookingConfirmationDto();
        bookingDto.setBookingStatus(bookingResponse.getBookingStatus());
        bookingDto.setBookindId(bookingResponse.getBookingId());
        List<String> seatDetails = new ArrayList<>();
        for (BookedSeats seats : bookingResponse.getBookedSeats()) {
            seatDetails.add(seats.getBookedSeatName());
        }
        bookingDto.setBookedSeat(seatDetails);
        return ResponseEntity.status(HttpStatus.OK).body(bookingDto);
    }
}
