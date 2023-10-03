package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.dto.CourseDTO;
import com.tecnocampus.erjose.domain.Course;
import com.tecnocampus.erjose.persistence.CourseRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<CourseDTO> getCoursesAvailable() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(CourseDTO::new).collect(Collectors.toList());
    }
    /*
        return courseRepository.findByAvailabilityOrderByTitleAsc(true).stream().map(this::mapToDTO).collect(Collectors.toList());
    */
    /*private CourseDTO mapToDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        dto.setDateOfPublication(course.getDateOfPublication());
        dto.setDateOfLastUpdate(course.getDateOfLastUpdate());
        dto.setImageUrl(course.getImageUrl());
        dto.setCurrentPrice(course.getCurrentPrice());
        dto.setAvailability(course.isAvailability());
        return dto;
    }
     */
}

