package com.tecnocampus.erjose.persistence;

import com.tecnocampus.erjose.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long>  {
    List<Course> findByAvailableOrderByTitle(boolean available);
    boolean existsByTitle(String title);
}
