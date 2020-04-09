package edu.practice.englishstudyservice.repos;

import edu.practice.englishstudyservice.entities.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word,String> {
}
