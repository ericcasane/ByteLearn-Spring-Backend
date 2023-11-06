package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.CategoryService;
import com.tecnocampus.erjose.application.dto.CategoryDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "2. Category Controller", description = "Controller to manage categories")
@RestController
@RequestMapping("/categories")
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
    @Operation(summary = "Create a new category", description = "Returns the created category")
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
        System.out.println("CategoryDTO: " + categoryDTO.name());
        return categoryService.createCategory(categoryDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a category", description = "Category with the given id must exist")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
