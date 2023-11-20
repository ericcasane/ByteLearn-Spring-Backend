package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User Controller", description = "Controller to manage users")
@RestController
@SecurityRequirement(name = "BearerAuth")
public class UserRestController {
    private final UserService userService;
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/users")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void upgradeUserToTeacher(@PathVariable String userId) {
        userService.upgradeUserToTeacher(userId);
    }
}
