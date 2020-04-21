package edu.practice.englishstudyservice.repos;

import edu.practice.englishstudyservice.domain.IrregularVerb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IrregularVerbRepository extends JpaRepository<IrregularVerb, String> {
}
