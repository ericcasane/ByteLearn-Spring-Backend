package com.tecnocampus.erjose.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "users")
public class User {
    @Id
    @UuidGenerator
    private String id;
    private String name;
    private String surname;
    @Email
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(unique = true)
    private String username;

    public User() {

    }
}
