package com.tecnocampus.erjose.persistence;

import com.tecnocampus.erjose.domain.NewLesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<NewLesson, String> {
}
