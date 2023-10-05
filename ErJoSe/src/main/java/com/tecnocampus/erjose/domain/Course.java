package com.tecnocampus.erjose.domain;

import com.tecnocampus.erjose.application.dto.CourseDTO;
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
    private LocalDate creationDate;
    private LocalDate lastUpdateDate;
    private String imageUrl;
    private double currentPrice;
    private boolean available;

    public Course() {

    }

    public Course(CourseDTO courseDTO) {
        this.title = courseDTO.getTitle();
        this.description = courseDTO.getDescription();
        this.imageUrl = courseDTO.getImageUrl();
        this.creationDate = LocalDate.now();
        this.lastUpdateDate = LocalDate.now();
        this.currentPrice = 0.0;
        this.available = false;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageURL(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void updateDate() {
        this.lastUpdateDate = LocalDate.now();
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

    public LocalDate getCreationDate() {
        return creationDate;
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
