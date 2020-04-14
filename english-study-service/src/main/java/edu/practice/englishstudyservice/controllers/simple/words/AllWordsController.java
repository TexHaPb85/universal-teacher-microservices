package edu.practice.englishstudyservice.controllers.simple.words;

import edu.practice.englishstudyservice.domain.Example;
import edu.practice.englishstudyservice.domain.Word;
import edu.practice.englishstudyservice.domain.serving.Action;
import edu.practice.englishstudyservice.services.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("words")
public class AllWordsController {
    private final WordService wordService;

    public AllWordsController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping
    public String getWords(Model model) {
        List<Word> words = wordService.getWords();
        model.addAttribute("words", words);
        model.addAttribute("newWord", new Word());
        model.addAttribute("action", new Action());
        return "words.html";
    }

    @PostMapping
    public String addWord(Word newWord, Action action) {
        wordService.addWord(newWord);
        System.out.println(action);

        return "redirect:/words";
    }


}
