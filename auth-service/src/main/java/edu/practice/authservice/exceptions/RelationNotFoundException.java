package edu.practice.authservice.exceptions;

public class RelationNotFoundException extends RuntimeException {
    public RelationNotFoundException(String id) {
        super("Profile with id: " + id + " not found");
    }
}
