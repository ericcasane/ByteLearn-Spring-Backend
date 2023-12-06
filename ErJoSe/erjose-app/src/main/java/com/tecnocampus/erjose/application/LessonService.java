package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.dto.LessonDTO;
import com.tecnocampus.erjose.application.dto.LessonDetailsDTO;
import com.tecnocampus.erjose.application.exception.NotFoundException;
import com.tecnocampus.erjose.domain.Lesson;
import com.tecnocampus.erjose.persistence.LessonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public LessonDTO createLesson(LessonDTO lessonDTO) {
        Lesson lesson = new Lesson(lessonDTO);
        lessonRepository.save(lesson);
        return new LessonDTO(lesson);
    }

    @Transactional
    public LessonDTO updateLesson(String lessonId, LessonDetailsDTO lessonDTO) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new NotFoundException("Lesson with id " + lessonId + " not found"));
        if (lessonDTO.title() != null) lesson.setTitle(lessonDTO.title());
        if (lessonDTO.description() != null) lesson.setDescription(lessonDTO.description());
        if (lessonDTO.duration() != null) lesson.setDuration(lessonDTO.duration());
        if (lessonDTO.videoUrl() != null) lesson.setVideoUrl(lessonDTO.videoUrl());
        if (lessonDTO.sequence() != null) lesson.setSequence(lessonDTO.sequence());
        return new LessonDTO(lesson);
    }
}
