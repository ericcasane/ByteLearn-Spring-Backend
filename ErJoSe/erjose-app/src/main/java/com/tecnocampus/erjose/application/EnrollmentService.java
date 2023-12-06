package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.dto.CourseDetailsDTO;
import com.tecnocampus.erjose.application.dto.EnrollmentDTO;
import com.tecnocampus.erjose.application.dto.ReviewDTO;
import com.tecnocampus.erjose.application.exception.CourseNotFoundException;
import com.tecnocampus.erjose.application.exception.EnrollmentNotFoundException;
import com.tecnocampus.erjose.application.exception.UserNotFoundException;
import com.tecnocampus.erjose.domain.Course;
import com.tecnocampus.erjose.domain.Enrollment;
import com.tecnocampus.erjose.domain.Review;
import com.tecnocampus.erjose.domain.User;
import com.tecnocampus.erjose.domain.enumeration.EEnrollmentState;
import com.tecnocampus.erjose.persistence.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {
    private final UserRepository userRepository;
    private final UserDetailsService userDetailsService;
    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentLessonRepository enrollmentLessonRepository;
    private final CourseRepository courseRepository;
    private final ReviewRepository reviewRepository;

    public EnrollmentService(UserRepository userRepository, UserDetailsService userDetailsService,
                             EnrollmentRepository enrollmentRepository,
                             EnrollmentLessonRepository enrollmentLessonRepository,
                             CourseRepository courseRepository,
                             ReviewRepository reviewRepository) {
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.enrollmentLessonRepository = enrollmentLessonRepository;
        this.courseRepository = courseRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<EnrollmentDTO> getUserEnrollments(Optional<EEnrollmentState> state){
        String username = userDetailsService.getAuthenticatedUsername();
        if (state.isEmpty())
            return enrollmentRepository.findByUsername(username);
        else
            return enrollmentRepository.findByUserAndState(username, state.get());
    }

    @Transactional
    public CourseDetailsDTO addReviewToCourse(Integer enrollmentId, ReviewDTO reviewDTO) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId).orElseThrow(() -> new EnrollmentNotFoundException(enrollmentId));
        User user = userRepository.findByUsername(userDetailsService.getAuthenticatedUsername()).orElseThrow(() -> new UserNotFoundException(userDetailsService.getAuthenticatedUsername()));
        if(!enrollment.halfLessonsDone())
            throw new IllegalStateException("An enrollment must be half completed to add a review");
        Course course = courseRepository.findById(enrollment.getCourseId()).orElseThrow(() -> new CourseNotFoundException(enrollment.getCourseId()));
        user.getReviews().stream().filter(review -> review.getCourse().getId().equals(course.getId())).findFirst().ifPresent(review -> {
            throw new IllegalStateException("A user cannot add more than one review to a course");
        });
        Review review = new Review(reviewDTO, course, user);
        course.addReview(review);
        user.addReview(review);
        reviewRepository.save(review);
        return new CourseDetailsDTO(course);
    }

    public CourseDetailsDTO editReview(Integer reviewId, String username) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new EnrollmentNotFoundException(reviewId));
        if(!username.equals(review.getUsername()))
            throw new IllegalStateException("Another user cannot edit the review");
        review.setComment("XD");
        reviewRepository.save(review);
        return new CourseDetailsDTO(course);
    }
}
