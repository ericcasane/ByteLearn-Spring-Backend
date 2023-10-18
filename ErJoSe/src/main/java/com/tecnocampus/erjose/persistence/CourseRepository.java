package com.tecnocampus.erjose.persistence;

import com.tecnocampus.erjose.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, String>  {
    List<Course> findByAvailableOrderByTitle(boolean available);
    boolean existsByTitle(String title);
    @Query("SELECT c FROM Course c WHERE LOWER(c.title) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(c.description) LIKE LOWER(CONCAT('%', :search, '%')) ORDER BY c.title")
    List<Course> findByTitleOrDescription(String search);
}
