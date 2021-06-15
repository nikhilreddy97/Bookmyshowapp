package com.online.movieticketbookingapp.repository;

import com.online.movieticketbookingapp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findAllByCityName(String cityName);
    Optional<Movie> findByMovieName(String movieName);
}
