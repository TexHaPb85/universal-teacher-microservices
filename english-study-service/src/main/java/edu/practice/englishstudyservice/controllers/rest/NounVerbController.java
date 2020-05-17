package edu.practice.englishstudyservice.controllers.rest;

import edu.practice.englishstudyservice.domain.NounVerb;
import edu.practice.englishstudyservice.services.NounVerbService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("noun-verbs")
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

    @GetMapping("/train/")
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
