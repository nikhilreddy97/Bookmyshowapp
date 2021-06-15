package com.online.movieticketbookingapp.repository;

import com.online.movieticketbookingapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUserIdAndPassword(String userId, String password);
}
