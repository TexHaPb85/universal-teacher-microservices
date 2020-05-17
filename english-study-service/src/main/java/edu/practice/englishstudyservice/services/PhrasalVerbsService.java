package edu.practice.englishstudyservice.services;

import edu.practice.englishstudyservice.domain.PhrasalVerb;
import edu.practice.englishstudyservice.repos.PhrasalVerbRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

@Service
public class PhrasalVerbsService {

    private final PhrasalVerbRepository phrasalVerbRepository;

    public PhrasalVerbsService(PhrasalVerbRepository phrasalVerbRepository) {
        this.phrasalVerbRepository = phrasalVerbRepository;
    }

    public List<PhrasalVerb> getAllOrderedByVerbs(){
        return phrasalVerbRepository.findByOrderByVerbAsc();
    }

    public List<PhrasalVerb> getPhrasalVerbsByVerb(String verb){
        return phrasalVerbRepository.findPhrasalVerbsByVerb(verb);
    }

    public List<PhrasalVerb>  getRandomPhrasalVerbs(){
        return getPhrasalVerbsByVerb(getRandomPhrasalVerb().getVerb());
    }

    public PhrasalVerb getRandomPhrasalVerb(){
        long count = phrasalVerbRepository.count();
        Random random = new Random();
        long id = 1 + random.nextInt((int) count);

        return phrasalVerbRepository
                .findById(id)
                .orElseThrow(()->new NoSuchElementException("random extraction exception"));
    }


}
