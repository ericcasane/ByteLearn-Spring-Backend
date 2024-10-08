package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.CategoryService;
import com.tecnocampus.erjose.application.dto.CategoryDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "3. Category", description = "Controller to manage categories")
@RestController
@RequestMapping("/categories")
@SecurityRequirement(name = "BearerAuth")
public class CategoryRestController {
    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @Operation(summary = "Gets all categories")
    public List<CategoryDTO> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('CREATE_CATEGORY')")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new category", description = "Returns the created category")
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_CATEGORY')")
    @Operation(summary = "Delete a category", description = "Category with the given id must exist")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
