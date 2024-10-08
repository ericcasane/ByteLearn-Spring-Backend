package com.tecnocampus.erjose.application.exception;

public class CourseTitleDuplicatedException extends RuntimeException{
    public CourseTitleDuplicatedException(String title) {
        super("Course with title '" + title + "' already exists");
    }
}
