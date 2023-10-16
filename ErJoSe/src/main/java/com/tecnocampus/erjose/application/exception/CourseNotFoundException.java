package com.tecnocampus.erjose.application.exception;

public class CourseNotFoundException extends  RuntimeException{
    public CourseNotFoundException(String id) {
        super("Course with id '" + id + "' doesn't exist");
    }
}
