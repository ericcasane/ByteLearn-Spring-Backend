package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.CourseService;
import com.tecnocampus.erjose.application.dto.CourseDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
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
    @Operation(summary = "Get all courses or search by title or description")
    public List<?> getCourses(@RequestParam(required = false) String search) {
        if (search != null)
            return courseService.getCoursesByTitleOrDescription(search);
        return courseService.getCoursesAvailable();
    }

    @PostMapping("/courses")
    @Operation(summary = "Create a new course")
    public CourseDTO createCourse(@Valid @RequestBody CourseDTO courseDTO) {
        return courseService.createCourse(courseDTO);
    }
    
    @PatchMapping("/courses/{courseId}")
    @Operation(summary = "Update course title, description or image url")
    public CourseDTO updateCourse(@PathVariable Long courseId, @RequestBody Map<String, String> updates) {
        return courseService.updateCourseTitleDescrOrImageURL(courseId, updates);
    }

    @PatchMapping("/courses/{courseId}/price")
    @Operation(summary = "Update course price")
    public CourseDTO updateCoursePrice(@PathVariable Long courseId, @Valid @RequestBody CourseDTO courseDTO) {
        return courseService.updatePrice(courseId, courseDTO.currentPrice());
    }

    @PatchMapping("/courses/{courseId}/available")
    @Operation(summary = "Update course available")
    public CourseDTO updateCourseAvailable(@PathVariable Long courseId, @Valid @RequestBody CourseDTO courseDTO) {
        return courseService.updateAvailable(courseId, courseDTO.available());
    }

}



