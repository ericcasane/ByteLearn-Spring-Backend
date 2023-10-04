package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.dto.CourseDTO;
import com.tecnocampus.erjose.domain.Course;
import com.tecnocampus.erjose.persistence.CourseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseDTO createCourse(CourseDTO courseDTO){
        Course course = new Course(courseDTO);
        courseRepository.save(course);
        return new CourseDTO(course);
    }

    public List<CourseDTO> getCoursesAvailable() {
        List<Course> courses = courseRepository.findByAvailableOrderByTitle(true);
        return courses.stream().map(CourseDTO::new).collect(Collectors.toList());
    }

    public CourseDTO modifyCourse(Long id, CourseDTO courseDTO) {
        Course course = courseRepository.findById(id).get();
        course.updateCourse(courseDTO);
        courseRepository.save(course);
        return new CourseDTO(course);
    }

    public CourseDTO updatePrice(Long id, double currentPrice) {
        Course course = courseRepository.findById(id).get();
        course.setCurrentPrice(currentPrice);
        courseRepository.save(course);
        return new CourseDTO(course);
    }

    public CourseDTO updateAvailable(Long id, boolean available) {
        Course course = courseRepository.findById(id).get();
        course.setAvailable(available);
        courseRepository.save(course);
        return new CourseDTO(course);
    }

}

