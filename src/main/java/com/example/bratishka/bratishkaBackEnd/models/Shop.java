package com.example.bratishka.bratishkaBackEnd.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="shop")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="link")
    private String link;

    @Column(name="name")
    private String name;

    @Column(name="link_ym")
    private String linkYm;

    @Column(name="phone")
    private String phone;

    @Column(name="link_tg")
    private String linkTg;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Barber> barbers;

    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;

}
