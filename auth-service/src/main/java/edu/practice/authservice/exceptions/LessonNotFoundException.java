package edu.practice.authservice.exceptions;

public class LessonNotFoundException extends RuntimeException {
    public LessonNotFoundException(String id) {
        super("Lesson with id: " + id + " not found");
    }
}
