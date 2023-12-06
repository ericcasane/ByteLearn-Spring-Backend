package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.dto.LessonDTO;
import com.tecnocampus.erjose.application.exception.NotFoundException;
import com.tecnocampus.erjose.domain.EnrollmentLesson;
import com.tecnocampus.erjose.persistence.EnrollmentLessonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnrollmentLessonService {
    private final EnrollmentLessonRepository enrollmentLessonRepository;

    public EnrollmentLessonService(EnrollmentLessonRepository enrollmentLessonRepository) {
        this.enrollmentLessonRepository = enrollmentLessonRepository;
    }

    @Transactional
    public void completeLesson(Integer lessonId) {
        EnrollmentLesson lesson = enrollmentLessonRepository.findById(lessonId).orElseThrow(() -> new NotFoundException("Lesson wit id " + lessonId + " not found"));
        lesson.completed();
    }

}
