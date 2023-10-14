package com.tecnocampus.erjose.persistence;

import com.tecnocampus.erjose.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long>  {
    List<Course> findByAvailableOrderByTitle(boolean available);
    boolean existsByTitle(String title);
    List<Course> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrderByTitle(String title, String description);
}
