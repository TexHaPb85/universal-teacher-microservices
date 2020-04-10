package edu.practice.englishstudyservice.controllers;

import edu.practice.englishstudyservice.entities.Word;
import edu.practice.englishstudyservice.services.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("words")
public class WordController {
    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping
    public String getWords(Model model) {
        List<Word> words = wordService.getWords();
        model.addAttribute("words", words);
        model.addAttribute("newWord", new Word());
        return "words.html";
    }

    @PostMapping
    public String addWord(@ModelAttribute Word newWord) {
        System.out.println(newWord);
        wordService.addWord(newWord);
        return "redirect:/words";
    }
}
