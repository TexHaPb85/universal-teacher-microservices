package edu.practice.authservice.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String id) {
        super("User with id: " + id + " not found");
    }
}
