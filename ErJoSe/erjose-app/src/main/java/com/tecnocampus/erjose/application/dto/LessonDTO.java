package com.tecnocampus.erjose.application.dto;

import com.tecnocampus.erjose.domain.NewLesson;

public record LessonDTO(
        String id,
        String title,
        String description
){
    public LessonDTO(NewLesson lesson) {
        this(lesson.getId(), lesson.getTitle(), lesson.getDescription());
    }
}
