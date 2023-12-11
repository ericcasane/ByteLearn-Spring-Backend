package com.tecnocampus.erjose.application.dto;

public record TopStudentDTO(
        String username,
        String fullName,
        Integer completedCourses
) {
}
