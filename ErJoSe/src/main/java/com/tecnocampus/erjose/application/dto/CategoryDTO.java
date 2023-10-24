package com.tecnocampus.erjose.application.dto;

import com.tecnocampus.erjose.domain.Category;

public record CategoryDTO (String name, String description) {
    public CategoryDTO() {
        this(null, null);
    }
    public CategoryDTO (Category category) {
        this(category.getName(), category.getDescription());
    }
}