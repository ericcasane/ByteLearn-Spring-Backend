package com.tecnocampus.erjose.domain;

import com.tecnocampus.erjose.application.dto.LanguageDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Pattern(regexp = "^[A-Z].*", message = "Name must begin with a capital letter")
    private String name;

    @Column(unique = true)
    @Pattern(regexp = "^[a-z]{2}_[A-Z]{2}$", message = "Locale must be in the format ll_CC")
    private String locale;

    private boolean defaultLanguage;

    @OneToMany(mappedBy = "language")
    private List<Course> courseList;

    public Language() {

    }

    public Language(LanguageDTO languageDTO) {
        this.name = languageDTO.name();
        this.locale = languageDTO.locale();
        this.defaultLanguage = false;
    }

    public String getName() { return name; }

    public String getLocale() {
        return locale;
    }

    public boolean isDefaultLanguage() {
        return defaultLanguage;
    }
}
