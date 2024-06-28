package com.tecnocampus.erjose.application.exception;

public class EnrollmentNotFoundException extends RuntimeException {
    public EnrollmentNotFoundException(Integer id) {
        super("Enrollment with id '" + id + "' doesn't exist");
    }
}
