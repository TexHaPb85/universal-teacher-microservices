package edu.practice.englishstudyservice.services;

import edu.practice.englishstudyservice.entities.Word;
import edu.practice.englishstudyservice.repos.ExamplesRepository;
import edu.practice.englishstudyservice.repos.WordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class WordService {

    private final WordRepository wordRepository;
    private final ExamplesRepository examplesRepository;

    public WordService(WordRepository wordRepository, ExamplesRepository examplesRepository) {
        this.wordRepository = wordRepository;
        this.examplesRepository = examplesRepository;
    }

    public List<Word> getWords() {
        return wordRepository.findAll();
    }

    public Word getWordById(String id) {
        return wordRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public Word addWord(Word word) {
        return wordRepository.save(word);
    }

    public void deleteWordById(String id) {
        wordRepository.deleteById(id);
    }
}
