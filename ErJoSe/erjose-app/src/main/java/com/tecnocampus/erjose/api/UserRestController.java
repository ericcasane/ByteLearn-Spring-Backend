package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.UserService;
import com.tecnocampus.erjose.application.dto.StudentDTO;
import com.tecnocampus.erjose.application.dto.TopStudentDTO;
import com.tecnocampus.erjose.application.dto.TopTeacherDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "8. User", description = "Controller to manage users")
@RestController
@RequestMapping("/users")
@SecurityRequirement(name = "BearerAuth")
public class UserRestController {
    private final UserService userService;
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Upgrade a user to teacher")
    public void upgradeUserToTeacher(@PathVariable String userId) {
        userService.upgradeUserToTeacher(userId);
    }

    @GetMapping("/teachers/top")
    public List<TopTeacherDTO> getTopTeachers(@RequestParam Integer top, @RequestParam Optional<Integer> year) {
        return userService.getTopTeachers(top, year.get());
    }

    @GetMapping("/students/top")
    @Operation(summary = "Get top students", description = "Returns the top students that has completed more courses")
    public List<TopStudentDTO> getTopStudents(@RequestParam Integer top) {
        return userService.getTopStudents(top);
    }

}
