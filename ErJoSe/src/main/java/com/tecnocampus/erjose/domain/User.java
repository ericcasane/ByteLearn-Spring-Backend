package com.tecnocampus.erjose.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "users")
public class User {
    @Id
    @UuidGenerator
    private String id;
    private String name;
    private String secondName;
    private String thirdName;
    private String email;
    private String gender;
    @Column(unique = true)
    private String username;

    public User() {

    }
}
