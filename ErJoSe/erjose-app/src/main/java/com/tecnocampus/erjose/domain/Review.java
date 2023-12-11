package com.tecnocampus.erjose.domain;

import com.tecnocampus.erjose.application.dto.ReviewDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String username;

    @NotBlank
    @Size(max = 100, message = "Title must be less than 100 characters")
    private String title;

    @NotBlank
    @Size(max = 250, message = "Comment must be less than 250 characters")
    private String comment;

    @Min(value = 0, message = "Rating minimum value is 0")
    @Max(value = 5, message = "Rating must be up to 5")
    private Integer rating;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    @ManyToOne
    private User user;

    @ManyToOne
    private Course course;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Review() {
    }

    public Review(ReviewDTO reviewDTO, String username, Course course, User user) {
        this.username = username;
        this.title = reviewDTO.title();
        this.comment = reviewDTO.comment();
        this.rating = reviewDTO.rating();
        this.course = course;
        this.user = user;
    }

    public String getUsername() { return username; }

    public String getTitle() {
        return title;
    }

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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Course getCourse() {
        return course;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
