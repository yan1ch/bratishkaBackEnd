package com.example.bratishka.bratishkaBackEnd.repositories;

import com.example.bratishka.bratishkaBackEnd.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAllByOrderByCityNameAsc();
}