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

    private Double duration;

    private String videoUrl;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToMany
    private List<Enrollment> enrollments;

    public Lesson() {
    }

    public Lesson(LessonDTO lessonDTO) {
        this.title = lessonDTO.title();
        this.description = lessonDTO.description();
        this.duration = lessonDTO.duration();
        this.videoUrl = lessonDTO.videoUrl();
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

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
