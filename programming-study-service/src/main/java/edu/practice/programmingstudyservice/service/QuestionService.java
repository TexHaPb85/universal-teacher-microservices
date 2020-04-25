package edu.practice.programmingstudyservice.service;

import edu.practice.programmingstudyservice.entities.Question;
import edu.practice.programmingstudyservice.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }
}
