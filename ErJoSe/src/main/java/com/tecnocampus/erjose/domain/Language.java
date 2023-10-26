package com.tecnocampus.erjose.domain;

import com.tecnocampus.erjose.application.dto.LanguageDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
