package com.tecnocampus.erjose.persistence;

import com.tecnocampus.erjose.domain.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
}
