package com.tecnocampus.erjose.application.dto;

import com.tecnocampus.erjose.domain.Review;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record ReviewDetailsDTO(
        String username,
        String title,
        String comment,
        Integer rating,
        String createdAt
) {
    public ReviewDetailsDTO(Review review) {
        this(
                review.getUsername(),
                review.getTitle(),
                review.getComment(),
                review.getRating(),
                formatCreatedAt(review.getCreatedAt())
        );
    }

    public ReviewDetailsDTO(String username, String title, String comment, Integer rating, LocalDateTime createdAt) {
        this(username, title, comment, rating, formatCreatedAt(createdAt));
    }

    private static String formatCreatedAt(LocalDateTime createdAt) {
        return createdAt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}
