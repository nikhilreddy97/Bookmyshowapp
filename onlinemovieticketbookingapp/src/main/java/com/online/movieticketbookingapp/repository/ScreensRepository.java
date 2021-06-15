package com.online.movieticketbookingapp.repository;

import com.online.movieticketbookingapp.entity.Screens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreensRepository extends JpaRepository<Screens,Integer> {
}
