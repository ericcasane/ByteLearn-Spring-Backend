package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.CourseService;
import com.tecnocampus.erjose.application.dto.CourseDTO;
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
    public List<CourseDTO> getCourses() {
        return courseService.getCoursesAvailable();
    }

    @PostMapping("/courses")
    public CourseDTO createCourse(@Valid @RequestBody CourseDTO courseDTO) {
        return courseService.createCourse(courseDTO);
    }
    
    @PatchMapping("/courses/{courseId}") //Update course title, description or image url
    public CourseDTO updateCourse(@PathVariable Long courseId, @RequestBody Map<String, String> updates) {
        return courseService.updateCourseTitleDescrOrImageURL(courseId, updates);
    }

    @PatchMapping("/courses/{courseId}/price")
    public CourseDTO updateCoursePrice(@PathVariable Long courseId, @Valid @RequestBody CourseDTO courseDTO) {
        return courseService.updatePrice(courseId, courseDTO.getCurrentPrice());
    }

    @PatchMapping("/courses/{courseId}/available")
    public CourseDTO updateCourseAvailable(@PathVariable Long courseId, @Valid @RequestBody CourseDTO courseDTO) {
        return courseService.updateAvailable(courseId, courseDTO.isAvailable());
    }

    @GetMapping("/courses/search")
    public List<CourseDTO> searchCourses(@RequestParam String search) {
        return courseService.getCoursesByTitleOrDescription(search);
    }

}



