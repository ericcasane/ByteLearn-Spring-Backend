package com.tecnocampus.erjose.persistence;

import com.tecnocampus.erjose.domain.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, String> {
}
