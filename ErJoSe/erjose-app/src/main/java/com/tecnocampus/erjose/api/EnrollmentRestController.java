package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.dto.CourseDetailsDTO;
import com.tecnocampus.erjose.application.dto.EnrollmentDTO;
import com.tecnocampus.erjose.application.EnrollmentService;
import com.tecnocampus.erjose.application.dto.ReviewDTO;
import com.tecnocampus.erjose.application.dto.StudentDTO;
import com.tecnocampus.erjose.domain.enumeration.EEnrollmentState;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "7. Enrollment", description = "Controller to manage enrollments")
@RestController
@RequestMapping("/enrollments")
@SecurityRequirement(name = "BearerAuth")
public class EnrollmentRestController {
    private final EnrollmentService enrollmentService;
    public EnrollmentRestController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('READ_ENROLLMENT')")
    @Operation(summary = "Gets enrollments of the user")
    public List<EnrollmentDTO> getUserEnrollments(
            @Parameter(description = "Filter by state of the lesson")
            @RequestParam Optional<EEnrollmentState> state,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        PageRequest pageRequest = PageRequest.of(page, size);
        return enrollmentService.getUserEnrollments(state, pageRequest);
    }

    @PostMapping("/{enrollmentId}/review")
    @PreAuthorize("hasAuthority('CREATE_COURSE_REVIEW')")
    @Operation(summary = "Add review to course", description = "The course id must exist")
    public CourseDetailsDTO addReviewToCourse(@PathVariable Integer enrollmentId, @Valid @RequestBody ReviewDTO reviewDTO) {
        return enrollmentService.addReviewToCourse(enrollmentId, reviewDTO);
    }

    @GetMapping("/{enrollmentId}/students")
    @PreAuthorize("hasAuthority('READ_ENROLLMENT')")
    @Operation(summary = "Get students of the course.", description = "Gets the current students and the ones who had finished the course 2 months ago at most")
    public List<StudentDTO> getStudentsOfCourse(@PathVariable Integer enrollmentId) {
        return enrollmentService.getStudentsOfCourse(enrollmentId);
    }
}
