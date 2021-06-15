package com.online.movieticketbookingapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Screens implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer screenId;
    private String screenName;
    @Enumerated(EnumType.STRING)
    private ScreenStatus screenStatus;
    private Integer totalSeats;
    private Integer noOfRows;
    private Integer noOfSeats;
    private String movieName;
    private String theaterName;
    @Column(columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;
    private String showStartTime;
    private String showEndTime;
}
