package com.tecnocampus.erjose.application.dto;

import com.tecnocampus.erjose.domain.Lesson;

public record LessonDTO(
        String title,
        String description,
        Double duration,
        String videoUrl
){
    public LessonDTO(Lesson lesson) {
        this(lesson.getTitle(), lesson.getDescription(), lesson.getDuration(), lesson.getVideoUrl());
    }
}
