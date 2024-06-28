package com.tecnocampus.erjose.application.dto;

import com.tecnocampus.erjose.domain.Course;

public record CourseDTO (
        String title,
        String description,
        String imageUrl
)
{
    public CourseDTO(Course course) {
        this(course.getTitle(), course.getDescription(), course.getImageUrl());
    }
}
