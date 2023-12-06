package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.dto.LessonDTO;
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
}
