package com.tecnocampus.erjose.application.dto;

import com.tecnocampus.erjose.domain.User;

public record StudentDTO (
        String username,
        String fullname
){
    public StudentDTO(User user) {
        this(user.getUsername(), user.getFullname());
    }
}
