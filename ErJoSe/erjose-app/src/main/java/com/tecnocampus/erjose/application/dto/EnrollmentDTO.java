package com.tecnocampus.erjose.application.dto;

import com.tecnocampus.erjose.application.dto.LessonDTO;
import com.tecnocampus.erjose.domain.Enrollment;
import com.tecnocampus.erjose.domain.enumeration.EEnrollmentState;

import java.util.List;

public record EnrollmentDTO (
        List<LessonDTO> lessons,
        Integer progress,
        EEnrollmentState state,
        String certificateId
){
    public EnrollmentDTO(Enrollment enrollment) {
        this(enrollment.getLessons().stream().map(LessonDTO::new).toList(),
                enrollment.getProgress(),
                enrollment.getState(),
                enrollment.getCertificateId());
    }
}
