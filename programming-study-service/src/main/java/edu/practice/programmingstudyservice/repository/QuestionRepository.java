package edu.practice.programmingstudyservice.repository;

import edu.practice.programmingstudyservice.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {

}
