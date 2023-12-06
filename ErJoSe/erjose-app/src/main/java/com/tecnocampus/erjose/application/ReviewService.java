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
        String username = userDetailsService.getAuthenticatedUsername();
        if (username == null)
            throw new UnauthorizedException("You are not authorized to get reviews");
        return reviewRepository.findByUsername(username);
    }

    public List<ReviewDetailsDTO> getReviews(String orderBy) {
        if (orderBy.equals("createdAt"))
            return reviewRepository.findAllByOrderByCreatedAtDesc();
        else if (orderBy.equals("rating"))
            return reviewRepository.findAllByOrderByRatingDesc();
        else
            throw new ResourceNotFoundException("Invalid orderBy parameter");
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
