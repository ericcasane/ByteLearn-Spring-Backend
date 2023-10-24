package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.CategoryService;
import com.tecnocampus.erjose.application.dto.CategoryDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryRestController {
    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) { this.categoryService = categoryService; }

    @GetMapping
    @Operation(summary = "Get all categories")
    public List<CategoryDTO> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping
    @Operation(summary = "Create a new category")
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }
}
