package com.tecnocampus.erjose.domain;

import com.tecnocampus.erjose.application.dto.CourseDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @UuidGenerator
    private String id;

    @NotBlank
    @Pattern(regexp = "^[A-Z].*", message = "Title must begin with a capital letter")
    private String title;

    @NotBlank
    @Size(max = 500, message = "Description must be less than 500 characters")
    private String description;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    @NotBlank
    private String imageUrl;

    @DecimalMin(value = "0.0", inclusive = true, message = "Price must be greater than 0")
    private BigDecimal currentPrice;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean available;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "course_categories",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    @ManyToOne
    private Language language;

    @OneToMany (
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Review> reviews;

    @ManyToMany(mappedBy = "purchasedCourses")
    private List<Order> orders;

    @OneToMany (
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Lesson> lessons;

    @OneToMany (
            mappedBy = "courseId",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Enrollment> enrollments;

    @ManyToMany
    private List<User> students;

    public Course() {

    }

    public Course(CourseDTO courseDTO) {
        this.title = courseDTO.title();
        this.description = courseDTO.description();
        this.imageUrl = courseDTO.imageUrl();
        this.currentPrice = new BigDecimal("0.0");
        this.available = false;
        this.categories = new HashSet<>();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageURL(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Instant getCreatedAt() { return createdAt; }

    public Instant getUpdatedAt() { return updatedAt; }

    public String getImageUrl() {
        return imageUrl;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public Set<Category> getCategories() { return categories; }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void addCategories(List<Category> categories){
        this.categories.addAll(categories);
    }

    public void addLesson(Lesson lesson) {
        this.lessons.add(lesson);
    }

    public List<Lesson> getLessons() {
        List<Lesson> orderedLessons = this.lessons;
        Collections.sort(orderedLessons);
        return orderedLessons;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void editReview(){

    }

    public void addStudent(User user) {
        this.students.add(user);
    }
}
