package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.CourseService;
import com.tecnocampus.erjose.application.dto.CourseDTO;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class CourseRestController {
    private final CourseService courseService;

    public CourseRestController(CourseService courseService) { this.courseService = courseService; }
    @GetMapping("/courses")
    public List<CourseDTO> getCourses() { return courseService.getCoursesAvailable(); }
}
