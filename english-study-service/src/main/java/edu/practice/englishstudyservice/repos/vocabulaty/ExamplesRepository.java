package edu.practice.englishstudyservice.repos.vocabulaty;

import edu.practice.englishstudyservice.domain.vocabulary.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamplesRepository extends JpaRepository<Example, String> {
}
