package com.tecnocampus.erjose.security.config;

import com.tecnocampus.erjose.application.UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityBeansConfig {

    private final UserDetailsService userDetailsService;

    public SecurityBeansConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.builder().username("admin")
                .password(passwordEncoder.encode("password123"))
                .authorities("ROLE_ADMIN")
                .build();
        UserDetails teacher = User.builder().username("teacher")
                .password(passwordEncoder.encode("password123"))
                .roles("TEACHER")
                .authorities("CREATE_COURSE")
                .build();
        UserDetails student = User.builder().username("student")
                .password(passwordEncoder.encode("password123"))
                .roles("STUDENT")
                .build();
        return new InMemoryUserDetailsManager(admin, teacher, student);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // CORS configuration for the frontend application with React
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                 .allowedOrigins("http://localhost:3000", "https://bytelearn-platform.vercel.app/") // React frontend url localhost:3000
                 .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
                 .maxAge(3600);
            }
        };
    }
}
