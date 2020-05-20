package edu.practice.englishstudyservice.repos.grammar;

import edu.practice.englishstudyservice.domain.grammar.GrammarLesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrammarLessonRepository extends JpaRepository<GrammarLesson, Long> {
    List<GrammarLesson> findByTopicOrderByLessonIdAsc(String lessonId);
}
