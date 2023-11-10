package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.dto.CategoryDTO;
import com.tecnocampus.erjose.application.dto.CourseDTO;
import com.tecnocampus.erjose.application.dto.SearchCourseDTO;
import com.tecnocampus.erjose.application.exception.CourseNotFoundException;
import com.tecnocampus.erjose.application.exception.CourseTitleDuplicatedException;
import com.tecnocampus.erjose.domain.Category;
import com.tecnocampus.erjose.domain.Course;
import com.tecnocampus.erjose.domain.Language;
import com.tecnocampus.erjose.persistence.CategoryRepository;
import com.tecnocampus.erjose.persistence.CourseRepository;
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

    public CourseService(CourseRepository courseRepository,
                         CategoryRepository categoryRepository) {
        this.courseRepository = courseRepository;
        this.categoryRepository = categoryRepository;
    }

    public CourseDTO createCourse(CourseDTO courseDTO) {
        if (courseRepository.existsByTitle(courseDTO.title()))
            throw new CourseTitleDuplicatedException(courseDTO.title());
        Course course = new Course(courseDTO);
        courseRepository.save(course);
        return new CourseDTO(course);
    }

    public List<CourseDTO> getCoursesAvailable() {
        List<Course> courses = courseRepository.findByAvailableOrderByTitle(true);
        return courses.stream().map(CourseDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public CourseDTO updateCourseTitleDescrOrImageURL(String id, Map<String, String> updates) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        if (updates.containsKey("title")) course.setTitle(updates.get("title"));
        if (updates.containsKey("description")) course.setDescription(updates.get("description"));
        if (updates.containsKey("imageUrl")) course.setImageURL(updates.get("imageUrl"));
        course.updateDate();
        return new CourseDTO(course);
    }

    @Transactional
    public CourseDTO updatePrice(String id, BigDecimal currentPrice) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        course.setCurrentPrice(currentPrice);
        course.updateDate();
        return new CourseDTO(course);
    }

    @Transactional
    public CourseDTO updateAvailable(String id, boolean available) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        course.setAvailable(available);
        course.updateDate();
        return new CourseDTO(course);
    }

    public List<SearchCourseDTO> getCoursesByTitleOrDescription(Optional<String> search) {
        return courseRepository.findByTitleOrDescription(search.get());
    }

    public List<SearchCourseDTO> getCoursesByLanguageOrCategory(Optional<List<Long>> categories, Optional<List<Long>> languages) {
        if (categories.isPresent() && languages.isPresent())
            return courseRepository.getCoursesByLanguageAndCategory(categories.get(), languages.get());
        if (categories.isPresent())
            return courseRepository.getCoursesByCategory(categories.get());
        else
           return courseRepository.getCoursesByLanguage(languages.get());
    }

    //TODO
    /*public List<SearchCourseDTO> getCoursesByCategoryAndLanguage(long category, long language) {
        //return courseRepository.findByCategoryIdAndLanguageId(category, language);
    }

    public List<SearchCourseDTO> getCoursesByLanguage(long language) {
        //return courseRepository.findByLanguageId(language);
    }

    public List<SearchCourseDTO> getCoursesByCategory(long category) {
        return courseRepository.findByCategoryId(category);
    }*/

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