package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.persistence.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void upgradeUserToTeacher(String id) {
        // TODO: implement this method
    }
}
