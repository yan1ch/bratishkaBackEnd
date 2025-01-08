package com.example.bratishka.bratishkaBackEnd.repositories;

import com.example.bratishka.bratishkaBackEnd.models.Barber;
import com.example.bratishka.bratishkaBackEnd.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarberRepository extends JpaRepository<Barber, Long> {
    List<Barber> findByShop(Shop shop);
}