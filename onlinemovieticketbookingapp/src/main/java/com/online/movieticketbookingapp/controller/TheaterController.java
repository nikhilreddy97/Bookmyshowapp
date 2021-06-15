package com.online.movieticketbookingapp.controller;

import com.online.movieticketbookingapp.dto.TheaterAddressDto;
import com.online.movieticketbookingapp.dto.TheaterCreateDto;
import com.online.movieticketbookingapp.dto.TheatersDto;
import com.online.movieticketbookingapp.entity.Address;
import com.online.movieticketbookingapp.entity.Theater;
import com.online.movieticketbookingapp.exceptions.TheaterDetailsException;
import com.online.movieticketbookingapp.service.TheaterService;
import com.online.movieticketbookingapp.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TheaterController {

    @Autowired
    TheaterService service;

    @PostMapping("/add/theater")
    public ResponseEntity<String> createTheater(@RequestBody TheaterCreateDto theater) throws Exception {
        service.createTheater(theater);
        return ResponseEntity.status(HttpStatus.CREATED).body("Theater Created Successfully");
    }

    @GetMapping("/get/theater/list-{movieName}")
    public ResponseEntity<List<TheaterAddressDto>> getAllTheatersByCityAndMovie(@PathVariable("movieName") String movieName) throws TheaterDetailsException {
        String cityName = Constants.CITY_NAME;
        Constants.MOVIE_NAME = movieName;
        List<Address> addressResponse = service.getAllTheatersByCityAndMovie(cityName, movieName);
        List<TheaterAddressDto> listTheatersDto = new ArrayList<>();
        for (Address address : addressResponse) {
            TheaterAddressDto theatersDto = new TheaterAddressDto();
            theatersDto.setTheaterName(address.getTheaters().getTheaterName());
            theatersDto.setTheaterId(address.getTheaters().getTheaterId());
            theatersDto.setMovieName(address.getTheaters().getMovie().getMovieName());
            theatersDto.setArea(address.getArea());
            theatersDto.setCity(address.getCity());
            theatersDto.setPincode(address.getPincode());
            theatersDto.setState(address.getState());
            theatersDto.setStreetNo(address.getStreetNo());
            theatersDto.setStatus(address.getTheaters().getStatus());
            listTheatersDto.add(theatersDto);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(listTheatersDto);
    }

    @GetMapping("/get/theater-{theaterName}")
    public ResponseEntity<TheatersDto> getTheaterDetails(@PathVariable("theaterName") String theaterName) throws TheaterDetailsException {
        Theater respone = service.getTheaterDetails(theaterName);
        TheatersDto theaterDto = new TheatersDto();
        theaterDto.setTheaterId(respone.getTheaterId());
        theaterDto.setTheaterName(respone.getTheaterName());
        theaterDto.setStatus(respone.getStatus());
        theaterDto.setMovieName(respone.getMovie().getMovieName());
        theaterDto.setArea(respone.getAddresses().getArea());
        theaterDto.setCity(respone.getAddresses().getCity());
        theaterDto.setPincode(respone.getAddresses().getPincode());
        theaterDto.setState(respone.getAddresses().getState());
        theaterDto.setStreetNo(respone.getAddresses().getStreetNo());
        theaterDto.setScreenName(respone.getScreens().getScreenName());
        theaterDto.setNoOfSeats(respone.getScreens().getNoOfSeats());
        theaterDto.setNoOfRows(respone.getScreens().getNoOfRows());
        theaterDto.setTotalSeats(respone.getScreens().getTotalSeats());
        return ResponseEntity.status(HttpStatus.OK).body(theaterDto);
    }
}
