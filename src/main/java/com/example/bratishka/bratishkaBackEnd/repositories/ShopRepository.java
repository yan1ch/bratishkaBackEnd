package com.example.bratishka.bratishkaBackEnd.repositories;

import com.example.bratishka.bratishkaBackEnd.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
}