package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.dto.EnrollmentDTO;
import com.tecnocampus.erjose.application.EnrollmentService;
import com.tecnocampus.erjose.application.dto.ReviewDTO;
import com.tecnocampus.erjose.domain.enumeration.EEnrollmentState;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
            @RequestParam Optional<EEnrollmentState> state) {
        return enrollmentService.getUserEnrollments(state);
    }
}
