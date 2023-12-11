package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.dto.ReviewDTO;
import com.tecnocampus.erjose.application.exception.ResourceNotFoundException;
import com.tecnocampus.erjose.application.exception.UnauthorizedException;
import com.tecnocampus.erjose.domain.Review;
import com.tecnocampus.erjose.application.dto.ReviewDetailsDTO;
import com.tecnocampus.erjose.persistence.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserDetailsService userDetailsService;

    public ReviewService(ReviewRepository reviewRepository, UserDetailsService userDetailsService) {
        this.reviewRepository = reviewRepository;
        this.userDetailsService = userDetailsService;
    }

    public List<ReviewDetailsDTO> getReviews() {
        return reviewRepository.getAllBy();
    }

    public List<ReviewDetailsDTO> getReviews(String orderBy) {
        if (orderBy.equals("createdAt"))
            return reviewRepository.findAllByOrderByCreatedAtAsc();
        else if (orderBy.equals("rating"))
            return reviewRepository.findAllByOrderByRatingAsc();
        else
            throw new ResourceNotFoundException("Invalid orderBy parameter");
    }

    public List<ReviewDetailsDTO> getStudentReviews() {
        String username = userDetailsService.getAuthenticatedUsername();
        if (username == null)
            throw new UnauthorizedException("You are not authorized to get this information");
        return reviewRepository.findByUsername(username);
    }

    @Transactional
    public ReviewDetailsDTO editReview(Integer reviewId, ReviewDTO reviewDTO) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new ResourceNotFoundException("Review not found with id " + reviewId));
        if (!review.getUsername().equals(userDetailsService.getAuthenticatedUsername()))
            throw new UnauthorizedException("You are not authorized to edit this review");
        if (reviewDTO.title() != null) review.setTitle(reviewDTO.title());
        if (reviewDTO.comment() != null) review.setComment(reviewDTO.comment());
        if (reviewDTO.rating() != null) review.setRating(reviewDTO.rating());
        return new ReviewDetailsDTO(review);
    }
}
