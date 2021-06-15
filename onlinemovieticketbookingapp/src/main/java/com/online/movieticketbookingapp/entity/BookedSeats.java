package com.online.movieticketbookingapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookedSeats implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookedSeatId;
    private String bookedSeatName;
    @JsonIgnore
    @ManyToOne(targetEntity = Booking.class)
    @JoinColumn(name = "bookingId")
    private Booking bookings;
}
