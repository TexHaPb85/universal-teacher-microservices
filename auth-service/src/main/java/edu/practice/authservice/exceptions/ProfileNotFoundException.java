package edu.practice.authservice.exceptions;

public class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException(String id) {
        super("Profile with id: " + id + " not found");
    }
}
