package com.tecnocampus.erjose.domain;

import com.tecnocampus.erjose.application.dto.LanguageDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Pattern(regexp = "^[A-Z].*", message = "Name must begin with a capital letter")
    private String name;
    @Column(unique = true)
    private String locale;
    private boolean defaultLanguage;
    @OneToMany
    private List<Course> courseList;

    //protected Course
    public Language() {

    }

    public Language(LanguageDTO languageDTO) {
        this.name = languageDTO.name();
        this.locale = languageDTO.locale();
    }

    public String getName() {
        return name;
    }

    public String getLocale() {
        return locale;
    }

    public boolean isDefaultLanguage() {
        return defaultLanguage;
    }
}
