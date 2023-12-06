package com.tecnocampus.erjose.persistence;

import com.tecnocampus.erjose.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
