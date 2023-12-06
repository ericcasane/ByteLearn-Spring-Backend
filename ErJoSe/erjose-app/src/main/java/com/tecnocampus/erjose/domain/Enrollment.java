package com.tecnocampus.erjose.domain;

import com.tecnocampus.erjose.domain.enumeration.EEnrollmentState;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "enrollments")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private User userId;

    @ManyToOne
    private Course courseId;

    @NotNull
    @Min(value = 0, message = "Progress must be greater than 0")
    private Integer progress;

    @Enumerated(EnumType.ORDINAL)
    private EEnrollmentState state;

    private String certificateId;

    @OneToMany(mappedBy = "enrollment", cascade = CascadeType.ALL)
    private List<EnrollmentLesson> enrollmentLessons;

    @CreationTimestamp
    private Instant enrolledAt;

    @UpdateTimestamp
    private Instant updatedAt;

    public Enrollment() {
        this.progress = 0;
        this.state = EEnrollmentState.NOT_STARTED;
    }

    public Enrollment(User userId, Course courseId) {
        this();
        this.userId = userId;
        this.courseId = courseId;
    }

    public User getUser() {
        return userId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public Integer getProgress() {
        return progress;
    }

    public EEnrollmentState getState() {
        return state;
    }

    public List<EnrollmentLesson> getEnrollmentLessons() {
        return enrollmentLessons;
    }

    public void incrementProgress() {
        this.progress++;
        if (this.progress.equals(this.courseId.getLessons().size())) {
            this.state = EEnrollmentState.COMPLETED;
        } else {
            this.state = EEnrollmentState.IN_PROGRESS;
        }
    }

}
