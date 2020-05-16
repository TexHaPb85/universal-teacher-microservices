package edu.practice.englishstudyservice.services;

import edu.practice.englishstudyservice.domain.IrregularVerb;
import edu.practice.englishstudyservice.repos.ExamplesRepository;
import edu.practice.englishstudyservice.repos.IrregularVerbRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class IrregularVerbService {
    private final Random random;
    private final IrregularVerbRepository verbRepository;
    private final ExamplesRepository examplesRepository;

    public IrregularVerbService(Random random, IrregularVerbRepository verbRepository, ExamplesRepository examplesRepository) {
        this.random = random;
        this.verbRepository = verbRepository;
        this.examplesRepository = examplesRepository;
    }

    public List<IrregularVerb> getIrrVerbs() {
        return verbRepository.findAll();
    }

    public IrregularVerb getVerbByInfinitive(String infinitive) {
        return verbRepository
                .findByInfinitive(infinitive)
                .orElseThrow(() -> new NoSuchElementException("word " + infinitive + " doesn`t found in DB"));
    }

    public IrregularVerb getRandomVerb() {
        long verbCount = verbRepository.count();
        long id = 1 + random.nextInt((int) verbCount);
        if(id<=0)
            id=1;

        return verbRepository
                .findById(id)
                .orElseThrow(()->new NoSuchElementException("random extraction exception"));
    }
}
