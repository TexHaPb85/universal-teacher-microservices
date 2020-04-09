package edu.practice.englishstudyservice.controllers;

import edu.practice.englishstudyservice.services.WordService;
import org.springframework.stereotype.Controller;

@Controller
public class WordController {
    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }


}
