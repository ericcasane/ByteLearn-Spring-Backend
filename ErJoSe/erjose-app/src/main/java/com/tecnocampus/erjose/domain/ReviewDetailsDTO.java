package com.tecnocampus.erjose.domain;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public record ReviewDetailsDTO (
        String username,
        String title,
        String comment,
        Integer rating,
        String date
){
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.of("Europe/Madrid"));
    public ReviewDetailsDTO(Review review){
        this(review.getUsername(), review.getTitle(), review.getComment(), review.getRating(), formatter.format(review.getCreatedAt()));
    }
}
