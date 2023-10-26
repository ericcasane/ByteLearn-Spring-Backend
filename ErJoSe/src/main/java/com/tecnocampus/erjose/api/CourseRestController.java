package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.CourseService;
import com.tecnocampus.erjose.application.dto.CourseDTO;
import com.tecnocampus.erjose.domain.Category;
import com.tecnocampus.erjose.domain.Language;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.core.annotation.Order;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "1. Course Controller", description = "Controller to manage courses")
@Order(1)
@RestController
@RequestMapping("/courses")
public class CourseRestController {
    private final CourseService courseService;

    public CourseRestController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    @Operation(summary = "Get courses", description = "Returns all courses available or filtered by search, language or category")
    public List<?> getCourses(@RequestParam(required = false) String search,
                              @RequestParam(required = false) int language,
                              @RequestParam(required = false) int category) {
        if (search != null) //Search by title or description
            return courseService.getCoursesByTitleOrDescription(search);
        if (language > 0 || category > 0)
            if (language > 0 && category > 0) //Search by language and category
                return courseService.getCoursesByCategoryAndLanguage(category, language);
            else if (category > 0) //Search by category
                return courseService.getCoursesByCategory(category);
            else //Search by language
                return courseService.getCoursesByLanguage(language);
        return courseService.getCoursesAvailable();
    }

    @PostMapping
    @Operation(summary = "Create a new course", description = "Returns the created course")
    public CourseDTO createCourse(@Valid @RequestBody CourseDTO courseDTO) {
        return courseService.createCourse(courseDTO);
    }
    
    @PatchMapping("/{courseId}")
    @Operation(summary = "Update course title, description or image url", description = "The course id must exist")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Course updated"),
            @ApiResponse(responseCode = "400", description = "Invalid course id"),
            @ApiResponse(responseCode = "404", description = "Course not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content =
                    { @Content(mediaType = "application/json", schema =
                      @Schema(implementation = ErrorResponse.class)) })

    })
    public CourseDTO updateCourse(@PathVariable String courseId, @RequestBody Map<String, String> updates) {
        return courseService.updateCourseTitleDescrOrImageURL(courseId, updates);
    }

    @PatchMapping("/{courseId}/price")
    @Operation(summary = "Update course price", description = "The course id must exist")
    public CourseDTO updateCoursePrice(@PathVariable String courseId, @Valid @RequestBody CourseDTO courseDTO) {
        return courseService.updatePrice(courseId, courseDTO.currentPrice());
    }

    @PatchMapping("/{courseId}/available")
    @Operation(summary = "Update course available", description = "The course id must exist")
    public CourseDTO updateCourseAvailable(@PathVariable String courseId, @Valid @RequestBody CourseDTO courseDTO) {
        return courseService.updateAvailable(courseId, courseDTO.available());
    }

}



