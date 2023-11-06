package com.tecnocampus.erjose.persistence;

import com.tecnocampus.erjose.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
