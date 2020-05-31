package edu.practice.englishstudyservice.services.grammar;

import edu.practice.englishstudyservice.domain.grammar.GrammarLesson;
import edu.practice.englishstudyservice.domain.grammar.GrammarTask;
import edu.practice.englishstudyservice.repos.grammar.GrammarLessonRepository;
import edu.practice.englishstudyservice.repos.grammar.GrammarTaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GrammarLessonsService {
    private final GrammarLessonRepository grammarLessonRepository;
    private final GrammarTaskRepository grammarTaskRepository;

    public GrammarLessonsService(GrammarLessonRepository grammarLessonRepository, GrammarTaskRepository grammarTaskRepository) {
        this.grammarLessonRepository = grammarLessonRepository;
        this.grammarTaskRepository = grammarTaskRepository;
    }

    public List<GrammarLesson> getOrderedLessonsByTopic(String topic){
        return grammarLessonRepository.findByTopicOrderByLessonIdAsc(topic);
    }

    public Optional<GrammarLesson> getLessonById(Long lessonId){
        return grammarLessonRepository.findById(lessonId);
    }

    public List<String> getTopics() {
        return grammarLessonRepository.findTopics();
    }

    public GrammarLesson storeLesson(GrammarLesson newLesson){
        return grammarLessonRepository.save(newLesson);
    }

    public GrammarLesson addTaskToLesson(GrammarTask task, Long lessonId){
        GrammarLesson lesson = grammarLessonRepository.findById(lessonId).orElseThrow(()->new NoSuchElementException());
        task.setLesson(lesson);
        grammarTaskRepository.save(task);
        return grammarLessonRepository.getOne(lessonId);
    }
}
