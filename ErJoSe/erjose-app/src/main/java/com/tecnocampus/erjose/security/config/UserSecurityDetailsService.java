package com.tecnocampus.erjose.security.config;

import com.tecnocampus.erjose.domain.UserSecurity;
import com.tecnocampus.erjose.persistence.UserSecRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityDetailsService implements UserDetailsService {
    private UserSecRepository userSecRepository;

    public UserSecurityDetailsService(UserSecRepository userSecRepository) {
        this.userSecRepository = userSecRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserSecurity user = userSecRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserSecurityDetails.build(user);
    }

}