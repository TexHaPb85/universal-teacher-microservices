package edu.practice.englishstudyservice.repos.vocabulaty;

import edu.practice.englishstudyservice.domain.vocabulary.NounVerb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NounVerbRepository extends JpaRepository<NounVerb, Long> {
    NounVerb findByNounVerb(String nounVerb);
}
