package com.online.movieticketbookingapp.service;

import com.online.movieticketbookingapp.dto.TheaterCreateDto;
import com.online.movieticketbookingapp.entity.Address;
import com.online.movieticketbookingapp.entity.Theater;
import com.online.movieticketbookingapp.exceptions.TheaterDetailsException;

import java.util.List;

public interface TheaterService {
    void createTheater(TheaterCreateDto theater) throws Exception;

    List<Address> getAllTheatersByCityAndMovie(String cityName, String movieName) throws TheaterDetailsException;

    Theater getTheaterDetails(String theaterName) throws TheaterDetailsException;
}
