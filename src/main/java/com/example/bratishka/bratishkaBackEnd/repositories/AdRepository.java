package com.example.bratishka.bratishkaBackEnd.repositories;

import com.example.bratishka.bratishkaBackEnd.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {

    List<Ad> findAllByOrderByNumberAsc();

}
