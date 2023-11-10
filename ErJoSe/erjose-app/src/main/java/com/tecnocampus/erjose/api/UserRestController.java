package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    private final UserService userService;
    public UserRestController(UserService userService) {
        this.userService = userService;
    }
    @PutMapping("/users")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void upgradeUserToTeacher(@PathVariable String id) {
        userService.upgradeUserToTeacher(id);
    }
}
