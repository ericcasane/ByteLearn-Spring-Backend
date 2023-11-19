package com.tecnocampus.erjose.application.dto;

import com.tecnocampus.erjose.domain.Lesson;

public record LessonDTO(
        String id,
        String title,
        String description,
        Double duration,
        String videoUrl
){
    public LessonDTO(Lesson lesson) {
        this(lesson.getId(), lesson.getTitle(), lesson.getDescription(), lesson.getDuration(), lesson.getVideoUrl());
    }
}
