package edu.practice.programmingstudyservice.service;

import edu.practice.programmingstudyservice.entities.Lesson;
import edu.practice.programmingstudyservice.entities.Task;
import edu.practice.programmingstudyservice.repository.LessonRepository;
import edu.practice.programmingstudyservice.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;
    private final TaskRepository taskRepository;

    public LessonService(LessonRepository lessonRepository, TaskRepository taskRepository) {
        this.lessonRepository = lessonRepository;
        this.taskRepository = taskRepository;
    }

    public List<Lesson> getOrderedLessonsByTopic(String topic){
        return lessonRepository.findByTopicOrderByLessonIdAsc(topic);
    }

    public Optional<Lesson> getLessonById(Long lessonId){
        return lessonRepository.findById(lessonId);
    }

    public List<String> getTopics() {
        return lessonRepository.findTopics();
    }

    public Lesson storeLesson(Lesson newLesson){
        return lessonRepository.save(newLesson);
    }

    public Lesson addTaskToLesson(Task task, Long lessonId){
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(()->new NoSuchElementException());
        task.setLesson(lesson);
        taskRepository.save(task);
        return lessonRepository.getOne(lessonId);
    }
}
