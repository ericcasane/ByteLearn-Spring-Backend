package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.dto.course.CourseDTO;
import com.tecnocampus.erjose.application.dto.course.SearchCourseDTO;
import com.tecnocampus.erjose.application.exception.CourseNotFoundException;
import com.tecnocampus.erjose.application.exception.CourseTitleDuplicatedException;
import com.tecnocampus.erjose.domain.Category;
import com.tecnocampus.erjose.domain.Course;
import com.tecnocampus.erjose.persistence.CategoryRepository;
import com.tecnocampus.erjose.persistence.CourseRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;
    private final UserDetailsService userDetailsService;


    public CourseService(CourseRepository courseRepository,
                         CategoryRepository categoryRepository, UserDetailsService userDetailsService) {
        this.courseRepository = courseRepository;
        this.categoryRepository = categoryRepository;
        this.userDetailsService = userDetailsService;
    }

    public CourseDTO createCourse(CourseDTO courseDTO) {
        if (courseRepository.existsByTitle(courseDTO.title()))
            throw new CourseTitleDuplicatedException(courseDTO.title());
        Course course = new Course(courseDTO);
        courseRepository.save(course);
        return new CourseDTO(course);
    }

    public List<CourseDTO> getCourses() {
        Boolean available = true;
        if (userDetailsService.hasPrivilege("READ_ALL_COURSES"))
            available = null;
        List<Course> courses = courseRepository.findByAvailableOrderByTitle(available);
        return courses.stream().map(CourseDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public CourseDTO updateCourseTitleDescrOrImageURL(String id, Map<String, String> updates) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        if (updates.containsKey("title")) course.setTitle(updates.get("title"));
        if (updates.containsKey("description")) course.setDescription(updates.get("description"));
        if (updates.containsKey("imageUrl")) course.setImageURL(updates.get("imageUrl"));
        return new CourseDTO(course);
    }

    @Transactional
    public CourseDTO updatePrice(String id, BigDecimal currentPrice) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        course.setCurrentPrice(currentPrice);
        return new CourseDTO(course);
    }

    @Transactional
    public CourseDTO updateAvailable(String id, boolean available) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        course.setAvailable(available);
        return new CourseDTO(course);
    }

    public List<SearchCourseDTO> getCoursesByTitleOrDescription(Optional<String> search) {
        Boolean available = true;
        if (userDetailsService.hasPrivilege("READ_ALL_COURSES"))
            available = null;
        return courseRepository.findByTitleOrDescription(search.get(), available);
    }

    public List<SearchCourseDTO> getCoursesByLanguageOrCategory(Optional<List<Long>> categories, Optional<List<Long>> languages) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Boolean available = true;
        if (userDetailsService.hasPrivilege("READ_ALL_COURSES"))
            available = null;
        if (categories.isPresent() && languages.isPresent())
            return courseRepository.getCoursesByLanguageAndCategory(categories.get(), languages.get(), available);
        if (categories.isPresent())
            return courseRepository.getCoursesByCategory(categories.get(), available);
        else
           return courseRepository.getCoursesByLanguage(languages.get(), available);
    }

    @Transactional
    public void addCategoriesToCourse(String courseId, List<Long> categoryIds) {
        Course course = courseRepository.findById(courseId).orElseThrow(); //Afegir tractament excepció //TODO
        List<Category> categories = categoryRepository.findAllById(categoryIds);
        course.addCategories(categories);
    }

    /*@Transactional
    public void addCategoryToCourse(String courseId, List<Long> categoryIds) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException(courseId));
        categoryIds.forEach(categoryId -> {
            course.addCategory(
                    categoryRepository.findById(String.valueOf(categoryId))
                            .orElseThrow(() -> new CourseNotFoundException(courseId)));
        });
    }*/
}