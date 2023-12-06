package com.tecnocampus.erjose.domain;

import com.tecnocampus.erjose.application.dto.ReviewDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String username;

    @NotBlank
    @Size(max = 250, message = "Comment must be less than 250 characters")
    private String comment;

    @Min(value = 1, message = "Rating must be greater than 0")
    @Max(value = 5, message = "Rating must be up to 5")
    private Integer rating;

    @ManyToOne
    private Course course;

    public Review() {
    }

    public Review(ReviewDTO reviewDTO, Course course) {
        this.username = reviewDTO.username();
        this.comment = reviewDTO.comment();
        this.rating = reviewDTO.rating();
        this.course = course;
    }

    public String getUsername() { return username; }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

}
