package com.online.movieticketbookingapp.repository;

import com.online.movieticketbookingapp.entity.Address;
import com.online.movieticketbookingapp.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepositoty extends JpaRepository<Address, Integer> {

    @Query("Select a from Address a where a.city = :cityName")
    List<Address> findByCity(String cityName);
}
