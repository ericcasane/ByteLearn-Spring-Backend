package com.tecnocampus.erjose.application.dto;

import com.tecnocampus.erjose.domain.Language;

public record LanguageDTO (String name, String locale, boolean defaultLanguage) {
    public LanguageDTO() {
        this(null, null,false);
    }
    public LanguageDTO (Language language) {
        this(language.getName(), language.getLocale(), language.isDefaultLanguage());
    }
}
