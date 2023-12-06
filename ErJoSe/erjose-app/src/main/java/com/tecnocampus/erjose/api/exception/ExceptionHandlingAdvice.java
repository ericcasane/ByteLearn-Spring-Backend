package com.tecnocampus.erjose.api.exception;

import com.tecnocampus.erjose.application.exception.CourseNotFoundException;
import com.tecnocampus.erjose.application.exception.CourseTitleDuplicatedException;
import com.tecnocampus.erjose.application.exception.EnrollmentNotFoundException;
import com.tecnocampus.erjose.application.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingAdvice {
    @ExceptionHandler(value = {CourseNotFoundException.class, UserNotFoundException.class, EnrollmentNotFoundException.class})
    public ResponseEntity<String> notFound(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(value = {CourseTitleDuplicatedException.class, IllegalStateException.class})
    public ResponseEntity<String> notEditable(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

}
