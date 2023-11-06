package com.tecnocampus.erjose.api.exception;

import com.tecnocampus.erjose.application.exception.CourseNotFoundException;
import com.tecnocampus.erjose.application.exception.CourseTitleDuplicatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingAdvice {
    @ExceptionHandler(value = {CourseNotFoundException.class})
    public ResponseEntity<String> notFound(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(CourseTitleDuplicatedException.class)
    public ResponseEntity<String> notEditable(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
