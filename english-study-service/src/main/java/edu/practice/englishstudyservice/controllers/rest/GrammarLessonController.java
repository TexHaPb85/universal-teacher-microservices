package edu.practice.englishstudyservice.controllers.rest;

import edu.practice.englishstudyservice.domain.grammar.GrammarLesson;
import edu.practice.englishstudyservice.domain.grammar.GrammarTask;
import edu.practice.englishstudyservice.services.grammar.GrammarLessonsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("grammar")
@CrossOrigin(origins="*")
public class GrammarLessonController {
    private final GrammarLessonsService grammarLessonsService;

    public GrammarLessonController(GrammarLessonsService grammarLessonsService) {
        this.grammarLessonsService = grammarLessonsService;
    }

    @GetMapping
    public ResponseEntity<List<String>> getTopics(){
        return ResponseEntity
                .ok(grammarLessonsService.getTopics());
    }
    @GetMapping("{topic}")
    public ResponseEntity<List<GrammarLesson>> getLessonsByTopic(@PathVariable String topic) {
        return ResponseEntity
                .ok(grammarLessonsService.getOrderedLessonsByTopic(topic));
    }

    @GetMapping("{topic}/{lessonId}")
    public ResponseEntity<GrammarLesson> getLesson(@PathVariable Long lessonId, @PathVariable String topic) {
        GrammarLesson grammarLesson = grammarLessonsService
                .getLessonById(lessonId)
                .orElseThrow(() -> new NoSuchElementException("There`s no lesson with id " + lessonId));
        return ResponseEntity
                .ok(grammarLesson);
    }

    @PostMapping("edit")
    public ResponseEntity<GrammarLesson> addLesson(@RequestBody GrammarLesson newLesson){
        return ResponseEntity
                .ok(grammarLessonsService.storeLesson(newLesson));
    }

    @PatchMapping("edit/{lessonId}")
    public ResponseEntity<GrammarLesson> addTask(@PathVariable Long lessonId, @RequestBody GrammarTask task){
        return ResponseEntity
                .ok(grammarLessonsService.addTaskToLesson(task,lessonId));
    }
}
