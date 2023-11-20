package com.tecnocampus.erjose.persistence;

import com.tecnocampus.erjose.application.dto.SearchCourseDTO;
import com.tecnocampus.erjose.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, String>  {
    @Query("""
        SELECT c
        FROM Course c
        LEFT JOIN c.categories
        WHERE (:available IS NULL OR c.available = :available)
        """)
    List<Course> findByAvailableOrderByTitle(Boolean available);

    boolean existsByTitle(String title);

    @Query(""" 
            SELECT new com.tecnocampus.erjose.application.dto.SearchCourseDTO(c.title, c.description)
            FROM Course c
            WHERE LOWER(c.title) LIKE LOWER(CONCAT('%', :search, '%'))
            OR LOWER(c.description) LIKE LOWER(CONCAT('%', :search, '%'))
            AND (:available IS NULL OR c.available = :available)
            ORDER BY c.title
            """)
    List<SearchCourseDTO> findByTitleOrDescription(String search, Boolean available);

    @Query("""
        SELECT new com.tecnocampus.erjose.application.dto.SearchCourseDTO(c.title, c.description)
        FROM Course c
        JOIN c.categories cat
        JOIN c.language l
        WHERE cat.id IN :categories AND l.id IN :languages AND (:available IS NULL OR c.available = :available)
        ORDER BY c.title
        """)
    List<SearchCourseDTO> getCoursesByLanguageAndCategory(List<Long> categories, List<Long> languages, Boolean available);

    @Query("""
            SELECT new com.tecnocampus.erjose.application.dto.SearchCourseDTO(c.title, c.description)
            FROM Course c
            JOIN c.categories cat
            WHERE cat.id IN :categories AND (:available IS NULL OR c.available = :available)
            ORDER BY c.title
            """)
    List<SearchCourseDTO> getCoursesByCategory(List<Long> categories, Boolean available);

    @Query("""
            SELECT new com.tecnocampus.erjose.application.dto.SearchCourseDTO(c.title, c.description)
            FROM Course c
            JOIN c.language l
            WHERE l.id IN :languages AND (:available IS NULL OR c.available = :available)
            ORDER BY c.title
            """)
    List<SearchCourseDTO> getCoursesByLanguage(List<Long> languages, Boolean available);

}
