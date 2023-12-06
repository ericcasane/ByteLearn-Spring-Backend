package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.LanguageService;
import com.tecnocampus.erjose.application.dto.LanguageDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "4. Language", description = "Controller to manage languages")
@RestController
@RequestMapping("/languages")
@SecurityRequirement(name = "BearerAuth")
public class LanguageRestController {
    private final LanguageService languageService;
    public LanguageRestController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping
    @Operation(summary = "Get all languages")
    public List<LanguageDTO> getLanguages() {
        return languageService.getLanguages();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('CREATE_LANGUAGE')")
    @Operation(summary = "Create a new language")
    @ResponseStatus(HttpStatus.CREATED)
    public LanguageDTO createLanguage(@Valid @RequestBody LanguageDTO languageDTO) {
        return languageService.createLanguage(languageDTO);
    }

    @PatchMapping
    @PreAuthorize("hasAuthority('UPDATE_LANGUAGE')")
    @Operation(summary = "Update language")
    public LanguageDTO updateLanguage(@Valid @RequestBody LanguageDTO languageDTO) {
        return languageService.updateLanguage(languageDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_LANGUAGE')")
    @Operation(summary = "Delete a language")
    public void deleteLanguage(@PathVariable long id) {
        languageService.deleteLanguage(id);
    }
}
