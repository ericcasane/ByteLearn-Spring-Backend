package com.tecnocampus.erjose.application.dto;


import com.tecnocampus.erjose.domain.Course;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDate publicationDate;
    private LocalDate lastUpdateDate;
    private String imageUrl;
    private BigDecimal currentPrice;
    private boolean available;

    public CourseDTO() {

    }
    public CourseDTO (String title, String description, String imageUrl) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.publicationDate = LocalDate.now();
        this.lastUpdateDate = LocalDate.now();
        this.available = false;
    }

    public CourseDTO(Course course) {
        this.id = course.getId();
        this.title = course.getTitle();
        this.description = course.getDescription();
        this.publicationDate = course.getCreationDate();
        this.lastUpdateDate = course.getLastUpdateDate();
        this.imageUrl = course.getImageUrl();
        this.currentPrice = course.getCurrentPrice() ;
        this.available = course.isAvailable();
    }

    public String getTitle() { return title; }

    public String getDescription() { return description; }

    public LocalDate getPublicationDate() { return publicationDate; }

    public LocalDate getLastUpdateDate() { return lastUpdateDate; }

    public String getImageUrl() { return imageUrl; }

    public BigDecimal getCurrentPrice() { return currentPrice; }

    public boolean isAvailable() { return available; }
}
