package com.online.movieticketbookingapp.service;

import com.online.movieticketbookingapp.entity.Booking;
import com.online.movieticketbookingapp.entity.BookingStatus;
import com.online.movieticketbookingapp.repository.BookingRepository;
import com.online.movieticketbookingapp.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository repository;

    @Override
    public Booking seatBooking(Booking booking)throws Exception {
        booking.setTheaterName(Constants.THEATER_NAME);
        booking.setBookingStatus(BookingStatus.CONFIRMED);
        booking.setMovieName(Constants.MOVIE_NAME);
        booking.setPaymentReference(Constants.paymentReference);
        booking.setScreenId(Constants.SCREEN_ID);
        booking.setUserId(1);
        booking.getBookedSeats().forEach(bookingSeats -> bookingSeats.setBookings(booking));
        Booking response = repository.save(booking);
        if (response == null) {
            throw new Exception("Seats not booked");
        }
        return response;
    }
}
