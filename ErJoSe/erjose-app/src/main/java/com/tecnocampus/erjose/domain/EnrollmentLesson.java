package com.tecnocampus.erjose.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class EnrollmentLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Enrollment enrollment;

    @ManyToOne
    private Lesson lesson;

    private Boolean done;

    public EnrollmentLesson() {
    }

    public EnrollmentLesson(Enrollment enrollment, Lesson lesson) {
        this.enrollment = enrollment;
        this.lesson = lesson;
        this.done = false;
    }

    public boolean isDone() {
        return done;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void completed() {
        this.done = true;
        this.enrollment.incrementProgress();
    }
}