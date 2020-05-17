package edu.practice.englishstudyservice.controllers.rest;

import edu.practice.englishstudyservice.domain.NounVerb;
import edu.practice.englishstudyservice.services.NounVerbService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("noun-verbs")
@CrossOrigin(origins="*")
public class NounVerbController {
    private final NounVerbService nounVerbService;

    public NounVerbController(NounVerbService nounVerbService) {
        this.nounVerbService = nounVerbService;
    }

    @GetMapping
    public ResponseEntity<List<NounVerb>> findAll(){
        return ResponseEntity
                .ok(nounVerbService.getAll());
    }

    @GetMapping("/train")
    public ResponseEntity<NounVerb> getRandomNoun(){
        return ResponseEntity
                .ok(nounVerbService.getRandomNoun());
    }

    @GetMapping("/train/{verb}")
    public ResponseEntity<NounVerb> getSpecificVerbNoun(@PathVariable String verb){
        return ResponseEntity
                .ok(nounVerbService.getNoun(verb));
    }
}
