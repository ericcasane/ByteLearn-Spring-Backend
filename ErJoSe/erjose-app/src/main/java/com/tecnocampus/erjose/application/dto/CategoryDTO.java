package com.tecnocampus.erjose.application.dto;

import com.tecnocampus.erjose.domain.Category;
import jakarta.validation.constraints.NotBlank;

public record CategoryDTO(
        Long id,
        String name,
        String description
) {
    public CategoryDTO(Category category) {
        this(category.getId(), category.getName(), category.getDescription());
    }
}