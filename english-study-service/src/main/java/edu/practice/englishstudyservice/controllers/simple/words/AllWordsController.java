package edu.practice.englishstudyservice.controllers.simple.words;

import edu.practice.englishstudyservice.domain.Example;
import edu.practice.englishstudyservice.domain.Word;
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

        return "words.html";
    }

    @PostMapping
    public String addWord(@ModelAttribute Word newWord) {
        System.out.println(newWord);
        wordService.addWord(newWord);

        return "redirect:/words";
    }

    @GetMapping("/{word}")
    public String getWord(@PathVariable String word, Model model) {
        Word wordObj = wordService.getWordById(word);
        model.addAttribute("word", wordObj.getWord());
        model.addAttribute("translation", wordObj.getTranslation());
        model.addAttribute("examples", wordObj.getExamples());
        model.addAttribute("example", new Example());
        return "word.html";
    }

    @PostMapping("/{word}")
    public String addExample(@PathVariable String word, @ModelAttribute Example example) {
        System.out.println(example);
        wordService.addExampleToWord(word, example);
        return "redirect:/words/" + word;
    }
}
