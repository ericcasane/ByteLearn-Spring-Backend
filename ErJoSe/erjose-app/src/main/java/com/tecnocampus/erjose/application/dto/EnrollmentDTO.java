package com.tecnocampus.erjose.application.dto;

import com.tecnocampus.erjose.application.dto.LessonDTO;
import com.tecnocampus.erjose.domain.Enrollment;
import com.tecnocampus.erjose.domain.EnrollmentLesson;
import com.tecnocampus.erjose.domain.Lesson;
import com.tecnocampus.erjose.domain.enumeration.EEnrollmentState;

import java.util.List;

public record EnrollmentDTO (
        String title,
        String progress,
        EEnrollmentState state,
        List<LessonDTO> enrollmentLessons
)
{
    public EnrollmentDTO(Enrollment enrollment) {
        this(
            enrollment.getCourse().getTitle(),
            enrollment.getProgress() + "/" + enrollment.getCourse().getLessons().size(),
            enrollment.getState(),
            enrollment.getEnrollmentLessons().stream().map(EnrollmentLesson::getLesson).map(LessonDTO::new).toList()
        );
    }
}
