package com.tecnocampus.erjose.domain;

import com.tecnocampus.erjose.application.dto.CategoryDTO;
import jakarta.persistence.*;
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
    private String name;
    private String description;

    @ManyToMany(mappedBy = "categories")
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
