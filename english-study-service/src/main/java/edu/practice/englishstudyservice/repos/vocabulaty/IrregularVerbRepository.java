package edu.practice.englishstudyservice.repos.vocabulaty;

import edu.practice.englishstudyservice.domain.vocabulary.IrregularVerb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IrregularVerbRepository extends JpaRepository<IrregularVerb, Long> {
    Optional<IrregularVerb> findByInfinitive(String infinitive);
}
