package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.CourseService;
import com.tecnocampus.erjose.application.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Tag(name = "2. Course", description = "Controller to manage courses")
@RestController
@RequestMapping("/courses")
@SecurityRequirement(name = "BearerAuth")
public class CourseRestController {
    private final CourseService courseService;

    public CourseRestController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    @Operation(summary = "Get courses", description = "Returns all courses available or filtered by search or language and/or category")
    public List<?> getCourses(Optional<String> search, @RequestParam Optional<List<Long>> categories, @RequestParam Optional<List<Long>> languages) {
        if (search.isPresent()) //Search by title or description
            return courseService.getCoursesByTitleOrDescription(search);
        if (!categories.isEmpty() || !languages.isEmpty()) //Search by language or category
            return courseService.getCoursesByLanguageOrCategory(categories, languages);
        return courseService.getCourses();
    }

    @GetMapping("/{courseId}")
    @Operation(summary = "Get course by id", description = "Returns the course with the given id")
    public CourseDetailsDTO getCourse(@PathVariable String courseId) {
        return courseService.getCourse(courseId);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('CREATE_COURSE')")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new course", description = "Returns the created course")
    public CourseDetailsDTO createCourse(@Valid @RequestBody CourseDTO courseDTO) {
        return courseService.createCourse(courseDTO);
    }
    
    @PatchMapping("/{courseId}")
    @PreAuthorize("hasAuthority('UPDATE_COURSE')")
    @Operation(summary = "Update course title, description or image url", description = "The course id must exist")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Course updated"),
            @ApiResponse(responseCode = "400", description = "Invalid course id"),
            @ApiResponse(responseCode = "404", description = "Course not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content =
                    { @Content(mediaType = "application/json", schema =
                      @Schema(implementation = ErrorResponse.class)) })
    })
    public CourseDetailsDTO updateCourse(@PathVariable String courseId, @RequestBody Map<String, String> updates) {
        return courseService.updateCourseTitleDescrOrImageURL(courseId, updates);
    }

    @PatchMapping("/{courseId}/price")
    @PreAuthorize("hasAuthority('UPDATE_COURSE')")
    @Operation(summary = "Update course price", description = "The course id must exist")
    public CourseDetailsDTO updateCoursePrice(@PathVariable String courseId, @Valid @RequestBody CourseDetailsDTO courseDetailsDTO) {
        return courseService.updatePrice(courseId, courseDetailsDTO.currentPrice());
    }

    @PatchMapping("/{courseId}/available")
    @PreAuthorize("hasAuthority('UPDATE_COURSE')")
    @Operation(summary = "Update course available", description = "The course id must exist")
    public CourseDetailsDTO updateCourseAvailable(@PathVariable String courseId, @Valid @RequestBody CourseDetailsDTO courseDetailsDTO) {
        return courseService.updateAvailable(courseId, courseDetailsDTO.available());
    }

    @PostMapping("/{courseId}/categories")
    @PreAuthorize("hasAuthority('UPDATE_COURSE')")
    @Operation(summary = "Add categories ids to course", description = "The course id must exist")
    public CourseDetailsDTO addCategoryToCourse(@PathVariable String courseId, @RequestBody CourseCategoriesDTO courseCategoriesDTO) {
        return courseService.addCategoriesToCourse(courseId, courseCategoriesDTO);
    }

    @PostMapping("/{courseId}/lessons")
    @PreAuthorize("hasAuthority('CREATE_LESSON')")
    @Operation(summary = "Add lessons to course", description = "The course id must exist")
    public CourseDetailsDTO addLessonsToCourse(@PathVariable String courseId, @Valid @RequestBody LessonDTO lessonDTO) {
        return courseService.addLessonToCourse(courseId, lessonDTO);
    }

    @PostMapping("/{courseId}/reviews")
    @PreAuthorize("hasAuthority('CREATE_COURSE_REVIEW')")
    @Operation(summary = "Add review to course", description = "The course id must exist")
    public CourseDetailsDTO addReviewToCourse(@PathVariable String courseId, @Valid @RequestBody ReviewDTO reviewDTO) {
        return courseService.addReviewToCourse(courseId, reviewDTO);
    }

}



