package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.dto.EnrollmentDTO;
import com.tecnocampus.erjose.application.exception.UserNotFoundException;
import com.tecnocampus.erjose.domain.User;
import com.tecnocampus.erjose.persistence.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {
    private final UserRepository userRepository;
    private final UserDetailsService userDetailsService;

    public EnrollmentService(UserRepository userRepository, UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
    }

    public List<EnrollmentDTO> getUserEnrollments(){
        String username = userDetailsService.getAuthenticatedUsername();
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
        return user.getEnrollments().stream().map(EnrollmentDTO::new).collect(Collectors.toList());
    }

}
