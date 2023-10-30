package com.tecnocampus.erjose.application.dto;

import com.tecnocampus.erjose.domain.Category;

public class CategoryDTO {
    private Long id;
    private String name;
    private String description;

    public CategoryDTO() {
    }

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.description = category.getDescription();
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }
}