package edu.practice.englishstudyservice.repos.grammar;

import edu.practice.englishstudyservice.domain.grammar.GrammarLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GrammarLessonRepository extends JpaRepository<GrammarLesson, Long> {
    final String FIND_TOPICS = "SELECT topic FROM grammar_lessons";

    List<GrammarLesson> findByTopicOrderByLessonIdAsc(String lessonId);

    @Query(value = FIND_TOPICS, nativeQuery = true)
    List<String> findTopics();
}
