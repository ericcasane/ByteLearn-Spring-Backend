package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.LanguageService;
import com.tecnocampus.erjose.application.dto.LanguageDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Language Controller", description = "Controller to manage languages")
@Order(3)
@RestController
@RequestMapping("/languages")
public class LanguageRestController {
    private final LanguageService languageService;
    public LanguageRestController(LanguageService languageService) { this.languageService = languageService; }

    @GetMapping
    @Operation(summary = "Get all languages")
    public List<LanguageDTO> getLanguages() {
        return languageService.getLanguages();
    }

    @PutMapping
    @Operation(summary = "Create a new language")
    public LanguageDTO createLanguage(LanguageDTO languageDTO) {
        return languageService.createLanguage(languageDTO);
    }

    @PatchMapping
    @Operation(summary = "Update language")
    public LanguageDTO updateLanguage(LanguageDTO languageDTO) {
        return languageService.updateLanguage(languageDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a language")
    public void deleteLanguage(@PathVariable long id) {
        languageService.deleteLanguage(id);
    }
}
