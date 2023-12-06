package com.tecnocampus.erjose.persistence;

import com.tecnocampus.erjose.application.dto.EnrollmentDTO;
import com.tecnocampus.erjose.domain.Enrollment;
import com.tecnocampus.erjose.domain.enumeration.EEnrollmentState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    @Query("""
        SELECT e
        FROM Enrollment e
        WHERE e.userId.username = :username AND e.state = :state
        """)
    public List<EnrollmentDTO> findByUserAndState(String username, EEnrollmentState state);

    @Query("""
        SELECT e
        FROM Enrollment e
        WHERE e.userId.username = :username
        """)
    public List<EnrollmentDTO> findByUsername(String username);
}
