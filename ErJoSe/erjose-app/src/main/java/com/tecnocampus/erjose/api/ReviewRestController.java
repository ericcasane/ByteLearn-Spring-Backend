package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.ReviewService;
import com.tecnocampus.erjose.application.dto.ReviewDTO;
import com.tecnocampus.erjose.application.dto.ReviewDetailsDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "9. Review", description = "Controller to manage reviews")
@RestController
@RequestMapping("/reviews")
@SecurityRequirement(name = "BearerAuth")
public class ReviewRestController {
    private final ReviewService reviewService;

    public ReviewRestController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    @Operation(summary = "Get all reviews", description = "Get all reviews. orderBy options: createdAt, rating")
    public List<ReviewDetailsDTO> getReviews(@RequestParam Optional<String> orderBy) {
        if (orderBy.isEmpty())
            return reviewService.getReviews();
        return reviewService.getReviews(orderBy.get());
    }

    @PatchMapping("/{reviewId}")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    @Operation(summary = "Edit a review")
    public ReviewDetailsDTO editReview(@PathVariable Integer reviewId, @Valid @RequestBody ReviewDTO reviewDTO) {
        return reviewService.editReview(reviewId, reviewDTO);
    }

    @GetMapping("/my")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public List<ReviewDetailsDTO> getStudentReviews() {
        return reviewService.getStudentReviews();
    }
}
