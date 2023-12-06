package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.EnrollmentLessonService;
import com.tecnocampus.erjose.application.LessonService;
import com.tecnocampus.erjose.application.dto.LessonDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Tag(name = "5. Lesson", description = "Controller to manage lessons")
@RestController
@RequestMapping("/lessons")
@SecurityRequirement(name = "BearerAuth")
public class LessonRestController {

    private final LessonService lessonService;
    private final EnrollmentLessonService enrollmentLessonService;

    public LessonRestController(LessonService lessonService, EnrollmentLessonService enrollmentLessonService) {
        this.lessonService = lessonService;
        this.enrollmentLessonService = enrollmentLessonService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('CREATE_LESSON')")
    @Operation(summary = "Create a lesson")
    public LessonDTO createLesson(@RequestBody LessonDTO lessonDTO) {
        return lessonService.createLesson(lessonDTO);
    }

    @PostMapping("/{lessonId}/completed")
    @PreAuthorize("hasAuthority('COMPLETE_LESSON')")
    @Operation(summary = "Complete a lesson")
    public void completeLesson(@PathVariable Integer lessonId) {
        enrollmentLessonService.completeLesson(lessonId);
    }
}
