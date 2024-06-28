package com.tecnocampus.erjose.application.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String id) {
        super("User with id '" + id + "' doesn't exist");
    }
}
