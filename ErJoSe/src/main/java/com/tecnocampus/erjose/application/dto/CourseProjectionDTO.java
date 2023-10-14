package com.tecnocampus.erjose.application.dto;

public class CourseProjectionDTO {
    private String title;
    private String description;

    public CourseProjectionDTO(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
