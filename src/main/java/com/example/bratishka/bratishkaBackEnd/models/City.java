package com.example.bratishka.bratishkaBackEnd.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="cities")
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="city_name")
    private String cityName;
}
