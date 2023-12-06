package com.tecnocampus.erjose.application.dto;


import com.tecnocampus.erjose.domain.Course;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record CourseDetailsDTO(
        String id,
        String title,
        String description,
        String imageUrl,
        BigDecimal currentPrice,
        boolean available,
        Set<CategoryDetailsDTO> categories,
        List<ReviewDTO> reviews
) {

    public CourseDetailsDTO(Course course) {
        this(
            course.getId(),
            course.getTitle(),
            course.getDescription(),
            course.getImageUrl(),
            course.getCurrentPrice(),
            course.isAvailable(),
            course.getCategories().stream()
                    .map(category -> new CategoryDetailsDTO(category.getId(), category.getName()))
                    .collect(Collectors.toSet()),
            course.getReviews() != null ? course.getReviews().stream()
                    .map(review -> new ReviewDTO(review.getUsername(), review.getComment(), review.getRating()))
                    .collect(Collectors.toList()) : Collections.emptyList()
        );
    }
}
