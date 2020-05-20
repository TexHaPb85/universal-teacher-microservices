package edu.practice.englishstudyservice.services.grammar;

import edu.practice.englishstudyservice.domain.grammar.GrammarLesson;
import edu.practice.englishstudyservice.repos.grammar.GrammarLessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrammarLessonsService {
    private final GrammarLessonRepository grammarLessonRepository;

    public GrammarLessonsService(GrammarLessonRepository grammarLessonRepository) {
        this.grammarLessonRepository = grammarLessonRepository;
    }

    public List<GrammarLesson> getOrderedLessonsByTopic(String topic){
        return grammarLessonRepository.findByTopicOrderByLessonIdAsc(topic);
    }

    public Optional<GrammarLesson> getLessonById(Long lessonId){
        return grammarLessonRepository.findById(lessonId);
    }
}
