package com.tecnocampus.erjose.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(unique = true)
    private String name;
    private String locale;
    private boolean defaultLanguage;
    @OneToMany
    private List<Course> courseList;

    //protected Course
    public Language() {

    }
}
