package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.dto.LessonDTO;
import com.tecnocampus.erjose.domain.NewLesson;
import com.tecnocampus.erjose.persistence.LessonRepository;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public LessonDTO createLesson(LessonDTO lessonDTO) {
        NewLesson lesson = new NewLesson(lessonDTO);
        lessonRepository.save(lesson);
        return new LessonDTO(lesson);
    }

}
