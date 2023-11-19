package com.tecnocampus.erjose.domain;

import com.tecnocampus.erjose.domain.enumeration.EEnrollmentState;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@Table
@Entity(name = "enrollments")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User userId;

    @ManyToOne
    private Course courseId;

    @ManyToMany
    private List<Lesson> lessons;

    private Integer progress;

    private EEnrollmentState state;

    private String certificateId;

    @CreationTimestamp
    private Instant enrolledAt;

    @UpdateTimestamp
    private Instant updatedAt;

    public Enrollment() {
        this.progress = 0;
        this.state = EEnrollmentState.IN_PROGRESS;
    }


    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public EEnrollmentState getState() {
        return state;
    }

    public void setState(EEnrollmentState state) {
        this.state = state;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public Instant getEnrolledAt() {
        return enrolledAt;
    }

    public void setEnrolledAt(Instant enrolledAt) {
        this.enrolledAt = enrolledAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
