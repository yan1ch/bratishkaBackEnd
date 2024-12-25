package com.example.bratishka.bratishkaBackEnd.repositories;

import com.example.bratishka.bratishkaBackEnd.models.Barber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberRepository extends JpaRepository<Barber, Long> {
}