package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.exception.UserNotFoundException;
import com.tecnocampus.erjose.domain.User;
import com.tecnocampus.erjose.persistence.UserRepository;
import com.tecnocampus.erjose.domain.UserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
