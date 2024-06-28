package com.tecnocampus.erjose.persistence;

import com.tecnocampus.erjose.application.dto.TopTeacherDTO;
import com.tecnocampus.erjose.domain.Review;
import com.tecnocampus.erjose.application.dto.ReviewDetailsDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<ReviewDetailsDTO> getAllBy(Pageable pageable);

    List<ReviewDetailsDTO> findByUsername(String username);

    List<ReviewDetailsDTO> findAllByOrderByCreatedAtAsc(Pageable pageable);

    List<ReviewDetailsDTO> findAllByOrderByRatingAsc(Pageable pageable);

    @Query("""
            SELECT new com.tecnocampus.erjose.application.dto.TopTeacherDTO(t.id, CONCAT(t.firstname, ' ', t.lastname), AVG(r.rating))
            FROM Review r
            JOIN r.course c
            JOIN c.teacher t
            WHERE (:year IS NULL OR YEAR(r.createdAt) = :year)
            GROUP BY t
            ORDER BY AVG(r.rating) DESC
            """)
    List<TopTeacherDTO> findTopTeachers(Integer year, Pageable pageable);
}
