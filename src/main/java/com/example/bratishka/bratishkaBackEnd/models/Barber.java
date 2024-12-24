package com.example.bratishka.bratishkaBackEnd.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="barber")
@Data
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="link")
    private String link;

    @ManyToOne
    @JoinColumn(name="shop_id")
    private Shop shop;

    @Column(name="mvp")
    private boolean mvp;

    @Column(name="name")
    private String name;

    @Column(name="experience")
    private int experience;

    @Column(name="age")
    private int age;

    @Column(name="info")
    private String info;

    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;
}
