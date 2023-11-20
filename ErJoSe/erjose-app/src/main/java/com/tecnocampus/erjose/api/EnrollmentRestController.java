package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.dto.EnrollmentDTO;
import com.tecnocampus.erjose.application.EnrollmentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Enrollment", description = "Controller to manage enrollments")
@RestController
@RequestMapping("/enrollments")
@SecurityRequirement(name = "BearerAuth")
public class EnrollmentRestController {
    private final EnrollmentService enrollmentService;
    public EnrollmentRestController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public List<EnrollmentDTO> getUserEnrollments() {
        return enrollmentService.getUserEnrollments();
    }
}
