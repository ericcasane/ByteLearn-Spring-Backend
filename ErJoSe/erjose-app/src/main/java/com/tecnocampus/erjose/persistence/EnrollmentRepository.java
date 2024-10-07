package com.tecnocampus.erjose.persistence;

import com.tecnocampus.erjose.application.dto.EnrollmentDTO;
import com.tecnocampus.erjose.application.dto.TopStudentDTO;
import com.tecnocampus.erjose.domain.Enrollment;
import com.tecnocampus.erjose.domain.enumeration.EEnrollmentState;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    @Query("""
        SELECT e
        FROM Enrollment e
        WHERE e.user.username = :username AND e.state = :state
        """)
    List<EnrollmentDTO> findByUserAndState(String username, EEnrollmentState state, Pageable pageable);

    @Query("""
        SELECT e
        FROM Enrollment e
        WHERE e.user.username = :username
        """)
    List<EnrollmentDTO> findByUsername(String username, Pageable pageable);

    @Query("""
            SELECT new com.tecnocampus.erjose.application.dto.TopStudentDTO(e.user.username, CONCAT(e.user.firstname, '', e.user.lastname) , CAST(COUNT(e) AS INTEGER))
            FROM Enrollment e
            WHERE e.state = com.tecnocampus.erjose.domain.enumeration.EEnrollmentState.COMPLETED
            GROUP BY e.user
            ORDER BY COUNT(e) DESC
            """)
    List<TopStudentDTO> findTopStudents(Pageable pageable);
}
