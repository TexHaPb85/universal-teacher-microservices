package edu.practice.englishstudyservice.repos;

import edu.practice.englishstudyservice.domain.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, String> {
}
