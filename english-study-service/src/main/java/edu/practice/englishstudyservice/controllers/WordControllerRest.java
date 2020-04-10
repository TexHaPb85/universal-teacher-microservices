package edu.practice.englishstudyservice.controllers;

import edu.practice.englishstudyservice.entities.Word;
import edu.practice.englishstudyservice.services.WordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("words-rest")
public class WordControllerRest {
    private final WordService wordService;

    public WordControllerRest(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping
    public ResponseEntity<List<Word>> getWords(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(wordService.getWords());
    }

    @PostMapping
    public ResponseEntity<Word> addWord(@RequestBody Word word){
        System.out.println(word);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(wordService.addWord(word));
    }
}
