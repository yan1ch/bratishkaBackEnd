package com.example.bratishka.bratishkaBackEnd.models;

import jakarta.persistence.*;

@Entity
@Table(name="ad")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="link")
    private String link;

    @Column(name="number")
    private int number;

    public Ad() {}

    public Ad(String link, int number) {
        this.link = link;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ad{" +
                "link='" + link + '\'' +
                ", number=" + number +
                '}';
    }
}
