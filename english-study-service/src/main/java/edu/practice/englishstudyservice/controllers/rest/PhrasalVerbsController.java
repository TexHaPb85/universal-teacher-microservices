package edu.practice.englishstudyservice.controllers.rest;

import edu.practice.englishstudyservice.domain.PhrasalVerb;
import edu.practice.englishstudyservice.services.PhrasalVerbsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("phrasal-verbs")
@CrossOrigin(origins="*")
public class PhrasalVerbsController {

    private final PhrasalVerbsService phrasalVerbsService;

    public PhrasalVerbsController(PhrasalVerbsService phrasalVerbsService) {
        this.phrasalVerbsService = phrasalVerbsService;
    }

    @GetMapping
    public ResponseEntity<List<PhrasalVerb>> getAllPhrasalVerbs(){
        return ResponseEntity
                .ok(phrasalVerbsService.getAllOrderedByVerbs());
    }

    @GetMapping("/train")
    public ResponseEntity<List<PhrasalVerb>> getVerbsByRandomVerb(){
        return ResponseEntity
                .ok(phrasalVerbsService.getRandomPhrasalVerbs());
    }

    @GetMapping("/train/{verb}")
    public ResponseEntity<List<PhrasalVerb>> getPhrasalVerbsByVerb(@PathVariable String verb){
        return ResponseEntity
                .ok(phrasalVerbsService.getPhrasalVerbsByVerb(verb));
    }
}
