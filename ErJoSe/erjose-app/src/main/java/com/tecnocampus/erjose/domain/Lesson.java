package com.tecnocampus.erjose.domain;

import com.tecnocampus.erjose.application.dto.LessonDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @UuidGenerator
    private String id;
    private String title;
    private String description;

    @ManyToOne
    private Course courses;

    @ManyToMany
    private List<Enrollment> enrollments;

    public Lesson() {
    }

    public Lesson(LessonDTO lessonDTO) {
        this.title = lessonDTO.title();
        this.description = lessonDTO.description();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
