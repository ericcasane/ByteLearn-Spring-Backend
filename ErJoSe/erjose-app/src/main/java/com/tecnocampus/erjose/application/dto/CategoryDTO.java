package com.tecnocampus.erjose.application.dto;

import com.tecnocampus.erjose.domain.Category;

public class CategoryDTO{
    private Long id;
    private String name;
    private String description;

    public CategoryDTO() {
    }

    public CategoryDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public CategoryDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public CategoryDTO(Category category) {
            this.id = category.getId();
            this.name = category.getName();
            this.description = category.getDescription();
    }
}