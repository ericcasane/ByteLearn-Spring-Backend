package com.tecnocampus.erjose.persistence;

import com.tecnocampus.erjose.domain.EnrollmentLesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentLessonRepository extends JpaRepository<EnrollmentLesson, Integer> {
}