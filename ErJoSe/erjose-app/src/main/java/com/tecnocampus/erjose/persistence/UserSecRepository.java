package com.tecnocampus.erjose.persistence;

import com.tecnocampus.erjose.domain.UserSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserSecRepository extends JpaRepository<UserSecurity, Long> {
    Optional<UserSecurity> findByUsername(String email);
}
