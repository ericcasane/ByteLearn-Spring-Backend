package com.tecnocampus.erjose.application.exception;

public class CourseNotFoundException extends  RuntimeException{
    public CourseNotFoundException(Long id) {
        super("Course with id " + id + " doesn't exist");
    }
}
