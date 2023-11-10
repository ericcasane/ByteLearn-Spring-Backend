package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.LessonService;
import com.tecnocampus.erjose.application.dto.LessonDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class LessonRestController {

    private final LessonService lessonService;

    public LessonRestController(LessonService lessonService) {
        this.lessonService = lessonService;
    }


    @PostMapping("/lessons")
    public LessonDTO createLesson(@RequestBody LessonDTO lessonDTO) {
        return lessonService.createLesson(lessonDTO);
    }

}
