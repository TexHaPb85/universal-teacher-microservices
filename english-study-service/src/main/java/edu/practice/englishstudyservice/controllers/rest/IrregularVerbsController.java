package edu.practice.englishstudyservice.controllers.rest;

import edu.practice.englishstudyservice.domain.vocabulary.IrregularVerb;
import edu.practice.englishstudyservice.services.vocabulary.IrregularVerbService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("irregular-verbs")
@CrossOrigin(origins="*")
public class IrregularVerbsController {
    private final IrregularVerbService irrVerbService;

    public IrregularVerbsController(IrregularVerbService irrVerbService) {
        this.irrVerbService = irrVerbService;
    }

    @GetMapping
    public ResponseEntity<List<IrregularVerb>> getAllVerbs(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(irrVerbService.getIrrVerbs());
    }

    @GetMapping("train")
    public ResponseEntity<IrregularVerb> getRandomVerb(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(irrVerbService.getRandomVerb());
    }

    @GetMapping("/train/{wordInfinitive}")
    public ResponseEntity<IrregularVerb> getVerb(@PathVariable String wordInfinitive){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(irrVerbService.getVerbByInfinitive(wordInfinitive));
    }
}
