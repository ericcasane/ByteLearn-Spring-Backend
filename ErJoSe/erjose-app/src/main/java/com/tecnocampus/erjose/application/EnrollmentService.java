package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.dto.CourseDetailsDTO;
import com.tecnocampus.erjose.application.dto.EnrollmentDTO;
import com.tecnocampus.erjose.application.dto.ReviewDTO;
import com.tecnocampus.erjose.application.dto.StudentDTO;
import com.tecnocampus.erjose.application.exception.CourseNotFoundException;
import com.tecnocampus.erjose.application.exception.EnrollmentNotFoundException;
import com.tecnocampus.erjose.application.exception.InvalidStateException;
import com.tecnocampus.erjose.application.exception.UserNotFoundException;
import com.tecnocampus.erjose.domain.Course;
import com.tecnocampus.erjose.domain.Enrollment;
import com.tecnocampus.erjose.domain.Review;
import com.tecnocampus.erjose.domain.User;
import com.tecnocampus.erjose.domain.enumeration.EEnrollmentState;
import com.tecnocampus.erjose.persistence.*;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {
    private final UserRepository userRepository;
    private final UserDetailsService userDetailsService;
    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;
    private final ReviewRepository reviewRepository;

    public EnrollmentService(UserRepository userRepository, UserDetailsService userDetailsService,
                             EnrollmentRepository enrollmentRepository,
                             CourseRepository courseRepository,
                             ReviewRepository reviewRepository) {
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<EnrollmentDTO> getUserEnrollments(Optional<EEnrollmentState> state, Pageable pageable){
        String username = userDetailsService.getAuthenticatedUsername();
        if (state.isEmpty())
            return enrollmentRepository.findByUsername(username, pageable);
        else
            return enrollmentRepository.findByUserAndState(username, state.get(), pageable);
    }

    @Transactional
    public CourseDetailsDTO addReviewToCourse(Integer enrollmentId, ReviewDTO reviewDTO) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId).orElseThrow(() -> new EnrollmentNotFoundException(enrollmentId));
        User user = userRepository.findByUsername(userDetailsService.getAuthenticatedUsername()).orElseThrow(() -> new UserNotFoundException(userDetailsService.getAuthenticatedUsername()));
        if (!enrollment.halfLessonsDone())
            throw new InvalidStateException("An enrollment must be half completed to add a review");
        Course course = courseRepository.findById(enrollment.getCourseId()).orElseThrow(() -> new CourseNotFoundException(enrollment.getCourseId()));
        user.getReviews().stream().filter(review -> review.getCourse().getId().equals(course.getId())).findFirst().ifPresent(review -> {
            throw new InvalidStateException("A user cannot add more than one review to a course");
        });
        Review review = new Review(reviewDTO, user.getUsername(), course, user);
        course.addReview(review);
        user.addReview(review);
        reviewRepository.save(review);
        return new CourseDetailsDTO(course);
    }

    public List<StudentDTO> getStudentsOfCourse(Integer enrollmentId) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId).orElseThrow(() -> new EnrollmentNotFoundException(enrollmentId));
        LocalDateTime twoMonthsAgo = LocalDateTime.now().minusMonths(2);
        return  courseRepository.getActualStudentsOfCourse(enrollment.getCourse().getId(), twoMonthsAgo);
    }
}
