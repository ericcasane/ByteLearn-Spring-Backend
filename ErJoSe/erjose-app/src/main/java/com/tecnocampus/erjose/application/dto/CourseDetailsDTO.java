package com.tecnocampus.erjose.application.dto;


import com.tecnocampus.erjose.domain.Course;
import com.tecnocampus.erjose.domain.ReviewDetailsDTO;

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
        List<ReviewDetailsDTO> reviews
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
                    .map(ReviewDetailsDTO::new)
                    .collect(Collectors.toList()) : Collections.emptyList()
        );
    }
}
