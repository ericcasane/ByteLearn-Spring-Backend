package com.tecnocampus.erjose.application.dto;

public record ReviewDTO (
        String username,
        String title,
        String comment,
        Integer rating
){
}
