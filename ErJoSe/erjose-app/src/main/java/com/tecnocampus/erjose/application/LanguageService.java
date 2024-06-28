package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.dto.LanguageDTO;
import com.tecnocampus.erjose.domain.Language;
import com.tecnocampus.erjose.persistence.LanguageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) { this.languageRepository = languageRepository; }

    public LanguageDTO createLanguage(LanguageDTO languageDTO) {
        Language language = new Language(languageDTO);
        languageRepository.save(language);
        return new LanguageDTO(language);
    }

    public List<LanguageDTO> getLanguages() {
        return languageRepository.findAll().stream().map(LanguageDTO::new).toList();
    }

    @Transactional
    public LanguageDTO updateLanguage(LanguageDTO languageDTO) {
        Language language = new Language(languageDTO);
        return new LanguageDTO(language);
    }

    @Transactional
    public void deleteLanguage(long id) {
        languageRepository.deleteById(id);
    }
}
