package com.tecnocampus.erjose.domain;

import com.tecnocampus.erjose.application.dto.CategoryDTO;
import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;

    @OneToMany
    private List<Course> courseList;

    public Category() {

    }

    public Category(CategoryDTO categoryDTO) {
        this.name = categoryDTO.name();
        this.description = categoryDTO.description();
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() { return name; }

    public String getDescription() { return description; }

}
