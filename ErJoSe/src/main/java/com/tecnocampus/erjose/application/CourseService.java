package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.dto.CourseDTO;
import com.tecnocampus.erjose.application.exception.CourseNotFoundException;
import com.tecnocampus.erjose.application.exception.CourseTitleDuplicatedException;
import com.tecnocampus.erjose.domain.Course;
import com.tecnocampus.erjose.persistence.CourseRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseDTO createCourse(CourseDTO courseDTO){
        if(courseRepository.existsByTitle(courseDTO.getTitle()))
            throw new CourseTitleDuplicatedException(courseDTO.getTitle());
        Course course = new Course(courseDTO);
        courseRepository.save(course);
        return new CourseDTO(course);
    }

    public List<CourseDTO> getCoursesAvailable() {
        List<Course> courses = courseRepository.findByAvailableOrderByTitle(true);
        return courses.stream().map(CourseDTO::new).collect(Collectors.toList());
    }

    public CourseDTO updateCourseTitleDescrOrImageURL(Long id, Map<String, String> updates) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        if (updates.containsKey("title")) course.setTitle(updates.get("title"));
        if (updates.containsKey("description")) course.setDescription(updates.get("description"));
        if (updates.containsKey("imageUrl")) course.setImageURL(updates.get("imageUrl"));
        course.updateDate();
        courseRepository.save(course);
        return new CourseDTO(course);
    }

    public CourseDTO updatePrice(Long id, BigDecimal currentPrice) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        course.setCurrentPrice(currentPrice);
        course.updateDate();
        courseRepository.save(course);
        return new CourseDTO(course);
    }

    public CourseDTO updateAvailable(Long id, boolean available) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        course.setAvailable(available);
        course.updateDate();
        courseRepository.save(course);
        return new CourseDTO(course);
    }

    public List<CourseDTO> getCoursesByTitleOrDescription(String text) {
        List<Course> courses = courseRepository.findByTitleOrDescriptionOrderByTitle(text);
        return courses.stream().map(course -> new CourseDTO(course.getTitle(), course.getDescription())).collect(Collectors.toList());
    }


    public List<CourseDTO> getCoursesByTitleAndDescription(String title) {
        List<Course> courses = courseRepository.findByTitleAndDescriptionOrderByTitle(title, description);
        return courses.stream().map(CourseDTO::new).collect(Collectors.toList());
    }
}

