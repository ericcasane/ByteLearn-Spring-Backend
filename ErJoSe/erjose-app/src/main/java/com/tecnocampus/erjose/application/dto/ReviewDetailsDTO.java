package com.tecnocampus.erjose.application.dto;

import com.tecnocampus.erjose.domain.Review;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public record ReviewDetailsDTO (
        String username,
        String title,
        String comment,
        Integer rating,
        String createdAt
){
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.of("Europe/Madrid"));
    public ReviewDetailsDTO(Review review){
        this(review.getUsername(), review.getTitle(), review.getComment(), review.getRating(), formatter.format(review.getCreatedAt()));
    }
}
