package edu.practice.englishstudyservice.repos;

import edu.practice.englishstudyservice.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamplesRepository extends JpaRepository<Example, String> {
}
