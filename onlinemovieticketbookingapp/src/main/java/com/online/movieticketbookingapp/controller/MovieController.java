package com.online.movieticketbookingapp.controller;

import com.online.movieticketbookingapp.entity.Movie;
import com.online.movieticketbookingapp.exceptions.MovieDetailsException;
import com.online.movieticketbookingapp.service.MovieService;
import com.online.movieticketbookingapp.util.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    MovieService service;

    @PostMapping(value = "/add")
    public ResponseEntity<String> addMovie(@Validated @RequestBody Movie movie) throws Exception {
        service.addMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body("Movie Added Succefully");
    }

    @GetMapping("/get/movie-{cityName}")
    public ResponseEntity<List<Movie>> getMovieListByCityName(@PathVariable("cityName") String cityName) throws MovieDetailsException {
        Constants.CITY_NAME = cityName;
        List<Movie> movieResponse = service.getMovieListByCityName(cityName);
        return ResponseEntity.status(HttpStatus.OK).body(movieResponse);
    }
}
