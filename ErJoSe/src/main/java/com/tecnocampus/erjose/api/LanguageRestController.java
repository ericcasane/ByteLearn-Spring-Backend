package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.LanguageService;
import com.tecnocampus.erjose.application.dto.LanguageDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageRestController {
    private final LanguageService languageService;
    public LanguageRestController(LanguageService languageService) { this.languageService = languageService; }

    /*@GetMapping
    @Operation(summary = "Get all languages")
    public List<LanguageDTO> getLanguages() {
        languageService.getLanguages();
    }

    @PutMapping
    @Operation(summary = "Create a new language")
    public LanguageDTO createLanguage(LanguageDTO languageDTO) {
        languageService.createLanguage(languageDTO);
    }

    @PatchMapping
    @Operation(summary = "Update language")
    public LanguageDTO updateLanguage(LanguageDTO languageDTO) {
        languageService.updateLanguage(languageDTO);
    }*/
}
