package com.online.movieticketbookingapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;
    private Integer screenId;
    private Integer userId;
    private String movieName;
    private String theaterName;
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;
    @CreationTimestamp
    private LocalDateTime bookingTime;
    private String paymentReference;
    @OneToMany(mappedBy = "bookings", cascade = CascadeType.ALL, orphanRemoval = true
    )
    private List<BookedSeats> bookedSeats;
}
