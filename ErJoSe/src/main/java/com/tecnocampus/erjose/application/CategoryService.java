package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.dto.CategoryDTO;
import com.tecnocampus.erjose.domain.Category;
import com.tecnocampus.erjose.persistence.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) { this.categoryRepository = categoryRepository; }

    public List<CategoryDTO> getCategories() {
        return categoryRepository.findAll().stream().map(CategoryDTO::new).toList();
    }
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO);
        categoryRepository.save(category);
        return new CategoryDTO(category);
    }

    @Transactional
    public void deleteCategory(String id) {
        categoryRepository.deleteById(id);
    }

}
