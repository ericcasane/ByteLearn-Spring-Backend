package com.tecnocampus.erjose.persistence;

import com.tecnocampus.erjose.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String email);
}
