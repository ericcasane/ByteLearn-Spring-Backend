package com.tecnocampus.erjose.persistence;

import com.tecnocampus.erjose.domain.Review;
import com.tecnocampus.erjose.application.dto.ReviewDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<ReviewDetailsDTO> getAllBy();

    List<ReviewDetailsDTO> findByUsername(String username);

    List<ReviewDetailsDTO> findAllByOrderByCreatedAtAsc();

    List<ReviewDetailsDTO> findAllByOrderByRatingAsc();
}
