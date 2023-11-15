package com.tecnocampus.erjose.application.dto.course;


import com.tecnocampus.erjose.application.dto.CategoryDetailsDTO;
import com.tecnocampus.erjose.domain.Category;
import com.tecnocampus.erjose.domain.Course;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public record CourseDTO (
        String id,
        String title,
        String description,
        Instant createdAt,
        Instant updatedAt,
        String imageUrl,
        BigDecimal currentPrice,
        boolean available,
        Set<CategoryDetailsDTO> categories
) {

    public CourseDTO(Course course) {
        this(
            course.getId(),
            course.getTitle(),
            course.getDescription(),
            course.getCreatedAt(),
            course.getUpdatedAt(),
            course.getImageUrl(),
            course.getCurrentPrice(),
            course.isAvailable(),
            course.getCategories().stream()
                    .map(category -> new CategoryDetailsDTO(category.getId(), category.getName()))
                    .collect(Collectors.toSet())
        );
    }
}
