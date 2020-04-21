package edu.practice.englishstudyservice.services;

import edu.practice.englishstudyservice.domain.IrregularVerb;
import edu.practice.englishstudyservice.repos.ExamplesRepository;
import edu.practice.englishstudyservice.repos.IrregularVerbRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class IrregularVerbService {
    private final IrregularVerbRepository verbRepository;
    private final ExamplesRepository examplesRepository;

    public IrregularVerbService(IrregularVerbRepository verbRepository, ExamplesRepository examplesRepository) {
        this.verbRepository = verbRepository;
        this.examplesRepository = examplesRepository;
    }

    public List<IrregularVerb> getIrrVerbs() {
        return verbRepository.findAll();
    }

    public IrregularVerb findVerbByInfinitive(String infinitiveId) {
        return verbRepository
                .findById(infinitiveId)
                .orElseThrow(() -> new NoSuchElementException("word " + infinitiveId + " doesn`t found in DB"));
    }
}
