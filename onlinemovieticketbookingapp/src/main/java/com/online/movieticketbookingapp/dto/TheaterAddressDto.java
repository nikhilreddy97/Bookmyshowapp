package com.online.movieticketbookingapp.dto;

import com.online.movieticketbookingapp.entity.Status;
import lombok.Data;

@Data
public class TheaterAddressDto {
    private Integer theaterId;
    private String theaterName;
    private Status status;
    private String movieName;
    private Integer streetNo;
    private String area;
    private String city;
    private String state;
    private String pincode;
}
