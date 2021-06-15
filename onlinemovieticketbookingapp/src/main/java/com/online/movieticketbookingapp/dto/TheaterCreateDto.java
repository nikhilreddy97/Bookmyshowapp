package com.online.movieticketbookingapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.online.movieticketbookingapp.entity.ScreenStatus;
import com.online.movieticketbookingapp.entity.Status;
import lombok.Data;

import java.sql.Date;

@Data
public class TheaterCreateDto {

    private String theaterName;
    private Status status;
    private String movieName;
    private Integer streetNo;
    private String area;
    private String city;
    private String state;
    private String pincode;
    private Integer totalSeats;
    private Integer noOfRows;
    private Integer noOfSeats;
    private String screenName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;
    private String showStartTime;
    private String showEndTime;
    private ScreenStatus screenStatus;

}
