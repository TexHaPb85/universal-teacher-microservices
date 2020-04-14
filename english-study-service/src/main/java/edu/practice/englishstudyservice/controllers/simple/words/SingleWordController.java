package edu.practice.englishstudyservice.controllers.simple.words;

import edu.practice.englishstudyservice.domain.Example;
import edu.practice.englishstudyservice.domain.Word;
import edu.practice.englishstudyservice.services.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("words")
public class SingleWordController {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(SingleWordController.class);

    private final WordService wordService;

    public SingleWordController(WordService wordService) {
        this.wordService = wordService;
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
        log.info("example: " + example + ", will be transmitted to service level");
        wordService.addExampleToWord(word, example);

        return "redirect:/words/" + word;
    }
}
