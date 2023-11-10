package com.tecnocampus.erjose.domain;

import com.tecnocampus.erjose.application.dto.LessonDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "lessons")
public class NewLesson {
    @Id
    @UuidGenerator
    private String id;
    private String title;
    private String description;

    public NewLesson() {
    }

    public NewLesson(LessonDTO lessonDTO) {
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
