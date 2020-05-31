package edu.practice.programmingstudyservice.controller;

import edu.practice.programmingstudyservice.entities.Lesson;
import edu.practice.programmingstudyservice.entities.Task;
import edu.practice.programmingstudyservice.service.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("study")
@CrossOrigin(origins="*")
public class LessonController {
    private final LessonService lessonsService;

    public LessonController(LessonService lessonsService) {
        this.lessonsService = lessonsService;
    }

    @GetMapping
    public ResponseEntity<List<String>> getTopics(){
        return ResponseEntity
                .ok(lessonsService.getTopics());
    }

    @GetMapping("{topic}")
    public ResponseEntity<List<Lesson>> getLessonsByTopic(@PathVariable String topic) {
        return ResponseEntity
                .ok(lessonsService.getOrderedLessonsByTopic(topic));
    }

    @GetMapping("{topic}/{lessonId}")
    public ResponseEntity<Lesson> getLesson(@PathVariable Long lessonId, @PathVariable String topic) {
        Lesson grammarLesson = lessonsService
                .getLessonById(lessonId)
                .orElseThrow(() -> new NoSuchElementException("There`s no lesson with id " + lessonId));
        return ResponseEntity
                .ok(grammarLesson);
    }

    @PostMapping("edit")
    public ResponseEntity<Lesson> addLesson(@RequestBody Lesson newLesson){
        return ResponseEntity
                .ok(lessonsService.storeLesson(newLesson));
    }

    @PatchMapping("edit/{lessonId}")
    public ResponseEntity<Lesson> addTask(@PathVariable Long lessonId, @RequestBody Task task){
        return ResponseEntity
                .ok(lessonsService.addTaskToLesson(task,lessonId));
    }
}
