package com.tecnocampus.erjose.domain;

import com.tecnocampus.erjose.domain.enumeration.EEnrollmentState;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "enrollments")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Course course;

    @NotNull
    @Min(value = 0, message = "Progress must be greater than 0")
    private Integer progress;

    @Enumerated(EnumType.ORDINAL)
    private EEnrollmentState state;

    private String certificateId;

    @OneToMany(mappedBy = "enrollment", cascade = CascadeType.ALL)
    private List<EnrollmentLesson> enrollmentLessons;

    @CreationTimestamp
    private LocalDateTime enrolledAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private LocalDateTime finishedAt;

    public Enrollment() {
        this.progress = 0;
        this.state = EEnrollmentState.NOT_STARTED;
    }

    public Enrollment(User user, Course course) {
        this();
        this.user = user;
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public Course getCourse() {
        return course;
    }

    public String getCourseId() {
        return course.getId();
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

    public boolean halfLessonsDone() {
        return this.progress >= this.course.getLessons().size() / 2;
    }

    public void incrementProgress() {
        this.progress++;
        if (this.progress.equals(this.course.getLessons().size())) {
            this.state = EEnrollmentState.COMPLETED;
            this.finishedAt = LocalDateTime.now();
        } else {
            this.state = EEnrollmentState.IN_PROGRESS;
        }
    }

    public void createEnrollmentLessons(List<Lesson> lessons) {
        for (Lesson lesson : lessons) {
            EnrollmentLesson enrollmentLesson = new EnrollmentLesson(this, lesson);
            enrollmentLessons.add(enrollmentLesson);
        }
    }

}
