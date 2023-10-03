package com.tecnocampus.erjose.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate publicationDate;
    private LocalDate lastUpdateDate;
    private String imageUrl;
    private Double currentPrice;
    private Boolean available;

    public Course() {

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public boolean isAvailable() {
        return available;
    }
}
