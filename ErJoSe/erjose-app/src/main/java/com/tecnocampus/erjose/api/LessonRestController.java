package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.LessonService;
import com.tecnocampus.erjose.application.dto.LessonDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Lesson Controller", description = "Controller to manage lessons")
@RestController
@RequestMapping("/lessons")
@SecurityRequirement(name = "BearerAuth")
public class LessonRestController {

    private final LessonService lessonService;

    public LessonRestController(LessonService lessonService) {
        this.lessonService = lessonService;
    }


    @PostMapping
    public LessonDTO createLesson(@RequestBody LessonDTO lessonDTO) {
        return lessonService.createLesson(lessonDTO);
    }

}
