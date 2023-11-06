package com.tecnocampus.erjose.persistence;

import com.tecnocampus.erjose.application.dto.SearchCourseDTO;
import com.tecnocampus.erjose.domain.Category;
import com.tecnocampus.erjose.domain.Course;
import com.tecnocampus.erjose.domain.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, String>  {
    List<Course> findByAvailableOrderByTitle(boolean available);
    boolean existsByTitle(String title);
    @Query(""" 
            SELECT new com.tecnocampus.erjose.application.dto.SearchCourseDTO(c.title, c.description) 
            FROM Course c
            WHERE LOWER(c.title) LIKE LOWER(CONCAT('%', :search, '%'))
            OR LOWER(c.description) LIKE LOWER(CONCAT('%', :search, '%'))
            ORDER BY c.title
            """)
    List<SearchCourseDTO> findByTitleOrDescription(String search);

    @Query("""
        SELECT new com.tecnocampus.erjose.application.dto.SearchCourseDTO(c.title, c.description)
        FROM Course c
        JOIN c.categories cat
        JOIN c.language l
        WHERE cat.id IN :categories AND l.id IN :languages
        ORDER BY c.title
        """)
    List<SearchCourseDTO> getCoursesByLanguageAndCategory(List<Long> categories, List<Long> languages);

    @Query("""
            SELECT new com.tecnocampus.erjose.application.dto.SearchCourseDTO(c.title, c.description)
            FROM Course c
            JOIN c.categories cat
            WHERE cat.id IN :categories
            ORDER BY c.title
            """)
    List<SearchCourseDTO> getCoursesByCategory(List<Long> categories);

    @Query("""
            SELECT new com.tecnocampus.erjose.application.dto.SearchCourseDTO(c.title, c.description)
            FROM Course c
            JOIN c.language l
            WHERE l.id IN :languages
            ORDER BY c.title
            """)
    List<SearchCourseDTO> getCoursesByLanguage(List<Long> languages);

}
