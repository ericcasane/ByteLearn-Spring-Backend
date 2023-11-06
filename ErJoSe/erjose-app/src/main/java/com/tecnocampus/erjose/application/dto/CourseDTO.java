package com.tecnocampus.erjose.application.dto;


import com.tecnocampus.erjose.domain.Category;
import com.tecnocampus.erjose.domain.Course;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public record CourseDTO (
        String id,
        String title,
        String description,
        LocalDate publicationDate,
        LocalDate lastUpdateDate,
        String imageUrl,
        BigDecimal currentPrice,
        boolean available,
        Set<Long> categories
) {

    public CourseDTO(Course course) {
        this(
            course.getId(),
            course.getTitle(),
            course.getDescription(),
            course.getCreationDate(),
            course.getLastUpdateDate(),
            course.getImageUrl(),
            course.getCurrentPrice(),
            course.isAvailable(),
            course.getCategories().stream()
                    .map(Category::getId)
                    .collect(Collectors.toSet())
        );
    }

    public CourseDTO(String title, String description, String imageUrl) {
        this(
            null,
            title,
            description,
            LocalDate.now(),
            LocalDate.now(),
            imageUrl,
            null,
            false,
            null
        );
    }
}
