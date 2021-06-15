package com.online.movieticketbookingapp.dto;

import com.online.movieticketbookingapp.entity.BookingStatus;
import lombok.Data;

import java.util.List;

@Data
public class BookingConfirmationDto {

    private Integer bookindId;
    private List<String> bookedSeat;
    private BookingStatus bookingStatus;
}
