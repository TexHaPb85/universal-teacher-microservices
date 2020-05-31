package edu.practice.programmingstudyservice.repository;

import edu.practice.programmingstudyservice.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
