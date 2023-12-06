package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.dto.EnrollmentDTO;
import com.tecnocampus.erjose.application.dto.ReviewDTO;
import com.tecnocampus.erjose.application.exception.UserNotFoundException;
import com.tecnocampus.erjose.domain.Review;
import com.tecnocampus.erjose.domain.User;
import com.tecnocampus.erjose.domain.enumeration.EEnrollmentState;
import com.tecnocampus.erjose.persistence.EnrollmentLessonRepository;
import com.tecnocampus.erjose.persistence.EnrollmentRepository;
import com.tecnocampus.erjose.persistence.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {
    private final UserRepository userRepository;
    private final UserDetailsService userDetailsService;
    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentLessonRepository enrollmentLessonRepository;

    public EnrollmentService(UserRepository userRepository, UserDetailsService userDetailsService,
                             EnrollmentRepository enrollmentRepository,
                             EnrollmentLessonRepository enrollmentLessonRepository) {
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.enrollmentLessonRepository = enrollmentLessonRepository;
    }

    public List<EnrollmentDTO> getUserEnrollments(Optional<EEnrollmentState> state){
        String username = userDetailsService.getAuthenticatedUsername();
        if (state.isEmpty())
            return enrollmentRepository.findByUsername(username);
        else
            return enrollmentRepository.findByUserAndState(username, state.get());
    }
}
