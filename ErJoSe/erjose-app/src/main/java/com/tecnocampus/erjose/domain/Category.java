package com.tecnocampus.erjose.domain;

import com.tecnocampus.erjose.application.dto.CategoryDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Enabled;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @ManyToMany(mappedBy = "categories", fetch=FetchType.EAGER)
    private Set<Course> courseList;

    public Category() {

    }

    public Category(CategoryDTO categoryDTO) {
        this.name = categoryDTO.name();
        this.description = categoryDTO.description();
        this.courseList = new HashSet<>();
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() { return name; }

    public String getDescription() { return description; }

}
