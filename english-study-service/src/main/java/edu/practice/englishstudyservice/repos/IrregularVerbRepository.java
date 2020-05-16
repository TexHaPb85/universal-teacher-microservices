package edu.practice.englishstudyservice.repos;

import edu.practice.englishstudyservice.domain.IrregularVerb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IrregularVerbRepository extends JpaRepository<IrregularVerb, Long> {
    Optional<IrregularVerb> findByInfinitive(String infinitive);
}
