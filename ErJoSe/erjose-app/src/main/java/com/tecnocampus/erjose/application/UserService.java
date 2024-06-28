package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.dto.StudentDTO;
import com.tecnocampus.erjose.application.dto.TopStudentDTO;
import com.tecnocampus.erjose.application.dto.TopTeacherDTO;
import com.tecnocampus.erjose.application.exception.UserNotFoundException;
import com.tecnocampus.erjose.domain.User;
import com.tecnocampus.erjose.persistence.EnrollmentRepository;
import com.tecnocampus.erjose.persistence.ReviewRepository;
import com.tecnocampus.erjose.persistence.UserRepository;
import com.tecnocampus.erjose.domain.UserDetails;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final EnrollmentRepository enrollmentRepository;

    public UserService(UserRepository userRepository, ReviewRepository reviewRepository,
                       EnrollmentRepository enrollmentRepository) {
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return UserDetails.build(user);
    }

    public boolean hasRole (String roleName) {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(roleName));
    }

    @Transactional
    public void upgradeUserToTeacher(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        /*if (user.hasRole("ROLE_USER"))
            user.addRole("ROLE_TEACHER");
        else
            throw new RuntimeException(String.format("User %s can't be upgraded to teacher", id));

         */
    }

    public List<TopTeacherDTO> getTopTeachers(Integer top, Integer year) {
        Pageable pageable = PageRequest.of(0, top);
        return reviewRepository.findTopTeachers(year, pageable);
    }

    public List<TopStudentDTO> getTopStudents(Integer top) {
        Pageable pageable = PageRequest.of(0, top);
        return enrollmentRepository.findTopStudents(pageable);
    }
}
