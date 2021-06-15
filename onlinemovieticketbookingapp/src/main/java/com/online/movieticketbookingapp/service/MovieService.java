package com.online.movieticketbookingapp.service;

import com.online.movieticketbookingapp.entity.Movie;
import com.online.movieticketbookingapp.exceptions.MovieDetailsException;

import java.util.List;

public interface MovieService {
    void addMovie(Movie movie) throws Exception;
    List<Movie> getMovieListByCityName(String cityName) throws MovieDetailsException;
}
