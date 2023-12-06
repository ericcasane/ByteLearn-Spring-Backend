package com.tecnocampus.erjose.application.dto;

import com.tecnocampus.erjose.domain.Lesson;

public record LessonDetailsDTO (
        String title,
        String description,
        Double duration,
        String videoUrl,
        Integer sequence
){
    public LessonDetailsDTO(Lesson lesson) {
        this(lesson.getTitle(), lesson.getDescription(), lesson.getDuration(), lesson.getVideoUrl(), lesson.getSequence());
    }}
