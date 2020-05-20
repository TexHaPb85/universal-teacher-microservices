package edu.practice.englishstudyservice.repos.vocabulaty;

import edu.practice.englishstudyservice.domain.vocabulary.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, String> {
}
