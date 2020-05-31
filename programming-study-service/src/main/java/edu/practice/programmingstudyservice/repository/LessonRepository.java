package edu.practice.programmingstudyservice.repository;

import edu.practice.programmingstudyservice.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    final String FIND_TOPICS = "SELECT DISTINCT topic FROM lessons";

    List<Lesson> findByTopicOrderByLessonIdAsc(String lessonId);

    @Query(value = FIND_TOPICS, nativeQuery = true)
    List<String> findTopics();
}
