package com.tecnocampus.erjose.domain;

import com.tecnocampus.erjose.application.dto.LessonDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "lessons")
public class Lesson implements Comparable<Lesson>{
    @Id
    @UuidGenerator
    private String id;

    @NotBlank
    @Size(max =100,  message = "Title must be less than 100 characters")
    private String title;

    @NotBlank
    @Size(max = 500, message = "Description must be less than 500 characters")
    private String description;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    private Integer sequence;

    @NotNull
    @Min(value = 0, message = "Duration must be greater than 0")
    private Double duration;

    @NotBlank
    private String videoUrl;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private List<EnrollmentLesson> enrollmentLessons;

    public Lesson() {
    }

    public Lesson(LessonDTO lessonDTO) {
        this.title = lessonDTO.title();
        this.description = lessonDTO.description();
        this.duration = lessonDTO.duration();
        this.videoUrl = lessonDTO.videoUrl();
    }

    public Lesson(LessonDTO lessonDTO, Course course) {
        this(lessonDTO);
        this.course = course;
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

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Double getDuration() {
        return duration;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public Integer getSequence() {
        return sequence;
    }

    @Override
    public int compareTo(Lesson otherLesson) {
        if (this.sequence != null && otherLesson.sequence != null) {
            // Si ambos tienen número de secuencia, compara por número de secuencia
            return Integer.compare(this.sequence, otherLesson.sequence);
        } else if (this.sequence != null) {
            // Si solo this tiene número de secuencia, colócalo antes
            return -1;
        } else if (otherLesson.sequence != null) {
            // Si solo otherLesson tiene número de secuencia, colócalo antes
            return 1;
        } else {
            // Si ninguno tiene número de secuencia, compara por fecha de creación
            return this.createdAt.compareTo(otherLesson.createdAt);
        }
    }
}
