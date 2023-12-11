package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.dto.*;
import com.tecnocampus.erjose.application.exception.CourseNotFoundException;
import com.tecnocampus.erjose.application.exception.CourseTitleDuplicatedException;
import com.tecnocampus.erjose.domain.*;
import com.tecnocampus.erjose.persistence.CategoryRepository;
import com.tecnocampus.erjose.persistence.CourseRepository;
import com.tecnocampus.erjose.persistence.LessonRepository;
import com.tecnocampus.erjose.persistence.ReviewRepository;
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
    private final LessonRepository lessonRepository;


    public CourseService(CourseRepository courseRepository,
                         CategoryRepository categoryRepository, UserDetailsService userDetailsService,
                         LessonRepository lessonRepository) {
        this.courseRepository = courseRepository;
        this.categoryRepository = categoryRepository;
        this.userDetailsService = userDetailsService;
        this.lessonRepository = lessonRepository;
    }

    public CourseDetailsDTO createCourse(CourseDTO courseDTO) {
        if (courseRepository.existsByTitle(courseDTO.title()))
            throw new CourseTitleDuplicatedException(courseDTO.title());
        User teacher = userDetailsService.getAuthenticatedUser();
        Course course = new Course(courseDTO, teacher);
        courseRepository.save(course);
        return new CourseDetailsDTO(course);
    }

    public CourseDetailsDTO getCourse(String id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        return new CourseDetailsDTO(course);
    }

    public List<CourseDetailsDTO> getCourses() {
        Boolean available = true;
        if (userDetailsService.hasPrivilege("READ_ALL_COURSES"))
            available = null;
        List<Course> courses = courseRepository.findByAvailableOrderByTitle(available);
        return courses.stream().map(CourseDetailsDTO::new).collect(Collectors.toList());
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
    public CourseDetailsDTO updateCourseTitleDescrOrImageURL(String id, Map<String, String> updates) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        if (course.isAvailable())
            throw new IllegalStateException("A course must be unavailable to modify");
        if (updates.containsKey("title")) course.setTitle(updates.get("title"));
        if (updates.containsKey("description")) course.setDescription(updates.get("description"));
        if (updates.containsKey("imageUrl")) course.setImageURL(updates.get("imageUrl"));
        return new CourseDetailsDTO(course);
    }

    @Transactional
    public CourseDetailsDTO updatePrice(String id, BigDecimal currentPrice) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        if (course.isAvailable())
            throw new IllegalStateException("A course must be unavailable to modify");
        course.setCurrentPrice(currentPrice);
        return new CourseDetailsDTO(course);
    }

    @Transactional
    public CourseDetailsDTO updateAvailable(String id, boolean available) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        if (course.getLessons().isEmpty())
            throw new IllegalStateException("A course must have at least one lesson to be available");
        course.setAvailable(available);
        return new CourseDetailsDTO(course);
    }

    @Transactional
    public CourseDetailsDTO addCategoriesToCourse(String courseId, CourseCategoriesDTO courseCategoriesDTO) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException(courseId));
        if(course.isAvailable())
            throw new IllegalStateException("A course must be unavailable to modify");
        List<Category> categories = categoryRepository.findAllById(courseCategoriesDTO.categoryIds());
        course.addCategories(categories);
        return new CourseDetailsDTO(course);
    }

    @Transactional
    public CourseDetailsDTO addLessonToCourse(String courseId, LessonDTO lessonDTO) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException(courseId));
        if(course.isAvailable())
            throw new IllegalStateException("A course must be unavailable to modify");
        Lesson lesson = new Lesson(lessonDTO, course);
        course.addLesson(lesson);
        lessonRepository.save(lesson);
        return new CourseDetailsDTO(course);
    }
}