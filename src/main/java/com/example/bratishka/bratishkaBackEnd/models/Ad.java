package com.example.bratishka.bratishkaBackEnd.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="ad")
@Data
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "link")
    private String link;

    @Column(name = "number")
    private int number;
}
