package com.tecnocampus.erjose.persistence;

import com.tecnocampus.erjose.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByTitleOrderByTitle(String title);

    //List<Course> findByAvailabilityOrderByTitleAsc(boolean availability);
}
