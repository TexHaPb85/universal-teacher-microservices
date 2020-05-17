package edu.practice.englishstudyservice.services;

import edu.practice.englishstudyservice.domain.NounVerb;
import edu.practice.englishstudyservice.repos.NounVerbRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class NounVerbService {
    private final NounVerbRepository nounVerbRepository;
    private final Random random;

    public NounVerbService(NounVerbRepository nounVerbRepository, Random random) {
        this.nounVerbRepository = nounVerbRepository;
        this.random = random;
    }

    public List<NounVerb> getAll(){
        return nounVerbRepository.findAll();
    }

    public NounVerb getNoun(String noun){
        return nounVerbRepository.findByNounVerb(noun);
    }

    public NounVerb getRandomNoun() {
        long verbCount = nounVerbRepository.count();
        long id = random.nextInt((int) verbCount);
        if(id<=0)
            id=1;

        return nounVerbRepository
                .findById(id)
                .orElseThrow(()->new NoSuchElementException("random extraction exception"));
    }
}
