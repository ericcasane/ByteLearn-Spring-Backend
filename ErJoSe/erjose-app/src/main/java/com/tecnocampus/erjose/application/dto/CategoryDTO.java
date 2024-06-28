package com.tecnocampus.erjose.application.dto;

import com.tecnocampus.erjose.domain.Category;
import jakarta.validation.constraints.NotBlank;

public record CategoryDTO(
        String name,
        String description
) {
    public CategoryDTO(Category category) {
        this(category.getName(), category.getDescription());
    }
}