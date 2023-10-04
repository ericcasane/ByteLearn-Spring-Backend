package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.CourseService;
import com.tecnocampus.erjose.application.dto.CourseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CourseRestController {
    private final CourseService courseService;

    public CourseRestController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<CourseDTO> getCourses() {
        return courseService.getCoursesAvailable();
    }

    @PostMapping("/courses")
    public CourseDTO createCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.createCourse(courseDTO);
    }
    
    @PatchMapping("/courses/{courseId}")
    public CourseDTO updateCourse(@PathVariable Long courseId, @RequestBody CourseDTO courseDTO) {

    }

    @PatchMapping("/courses/{courseId}/price")
    public CourseDTO updateCoursePrice(@PathVariable Long courseId, @RequestBody CourseDTO courseDTO) {
        return courseService.updatePrice(courseId, courseDTO.getCurrentPrice());
    }

    @PatchMapping("/courses/{courseId}/available")
    public CourseDTO updateCourseAvailable(@PathVariable Long courseId, @RequestBody CourseDTO courseDTO) {
        return courseService.updateAvailable(courseId, courseDTO.isAvailable());
    }
}



