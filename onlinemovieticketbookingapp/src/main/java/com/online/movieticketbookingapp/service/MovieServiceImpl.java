package com.online.movieticketbookingapp.service;

import com.online.movieticketbookingapp.entity.Movie;
import com.online.movieticketbookingapp.exceptions.MovieDetailsException;
import com.online.movieticketbookingapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    private final MovieRepository repository;

    @Autowired
    public MovieServiceImpl(MovieRepository repository) {
        this.repository = repository;
    }


    @Override
    public void addMovie(Movie movie) throws Exception {
        Movie movieResponse = repository.save(movie);
        if (movieResponse == null) {
            throw new Exception("City details not found");
        }
    }

    @Override
    public List<Movie> getMovieListByCityName(String cityName) throws MovieDetailsException {
        List<Movie> response = repository.findAllByCityName(cityName);
        if (response == null || response.isEmpty()) {
            throw new MovieDetailsException("Movie Details Not found with " +cityName);
        }
        return response;
    }
}
