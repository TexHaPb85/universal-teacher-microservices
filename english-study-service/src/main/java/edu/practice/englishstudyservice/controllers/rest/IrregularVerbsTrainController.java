package edu.practice.englishstudyservice.controllers.rest;

import edu.practice.englishstudyservice.domain.IrregularVerb;
import edu.practice.englishstudyservice.services.IrregularVerbService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("irregular-verbs-train")
public class IrregularVerbsTrainController {
    private final IrregularVerbService irrVerbService;

    public IrregularVerbsTrainController(IrregularVerbService irrVerbService) {
        this.irrVerbService = irrVerbService;
    }

    @GetMapping
    public ResponseEntity<List<IrregularVerb>> getAllVerbs(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(irrVerbService.getIrrVerbs());
    }

    @GetMapping("{wordInf}")
    public ResponseEntity<IrregularVerb> getVerb(@PathVariable String wordInf){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(irrVerbService.findVerbByInfinitive(wordInf));
    }

    @GetMapping("rand")
    public ResponseEntity<IrregularVerb> getRandomVerb(){
        List<IrregularVerb> verbs = irrVerbService.getIrrVerbs();
        int randElementIndex = (int) (Math.random()*verbs.size());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(verbs.get(randElementIndex));
    }
}
