package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.ReviewService;
import com.tecnocampus.erjose.application.UserDetailsService;
import com.tecnocampus.erjose.application.dto.ReviewDTO;
import com.tecnocampus.erjose.application.dto.ReviewDetailsDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "9. Review", description = "Controller to manage reviews")
@RestController
@RequestMapping("/reviews")
@SecurityRequirement(name = "BearerAuth")
public class ReviewRestController {
    private final ReviewService reviewService;
    private final UserDetailsService userDetailsService;

    public ReviewRestController(ReviewService reviewService, UserDetailsService userDetailsService) {
        this.reviewService = reviewService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping
    @Operation(summary = "Gets reviews of the user")
    public List<ReviewDetailsDTO> getUserReviews() {
        return reviewService.getUserReviews(userDetailsService.getAuthenticatedUsername());
    }

    @PatchMapping("/{reviewId}")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    @Operation(summary = "Edit a review")
    public ReviewDetailsDTO editReview(@PathVariable Integer reviewId, @Valid @RequestBody ReviewDTO reviewDTO) {
        return reviewService.editReview(reviewId, reviewDTO);
    }
}
