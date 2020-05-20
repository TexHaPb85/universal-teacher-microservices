package edu.practice.englishstudyservice.services.vocabulary;

import edu.practice.englishstudyservice.domain.vocabulary.IrregularVerb;
import edu.practice.englishstudyservice.repos.vocabulaty.ExamplesRepository;
import edu.practice.englishstudyservice.repos.vocabulaty.IrregularVerbRepository;
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

        return verbRepository
                .findById(id)
                .orElseThrow(()->new NoSuchElementException("random extraction exception"));
    }
}
