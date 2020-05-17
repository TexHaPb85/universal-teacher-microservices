package edu.practice.englishstudyservice.repos;

import edu.practice.englishstudyservice.domain.NounVerb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NounVerbRepository extends JpaRepository<NounVerb, Long> {
    NounVerb findByNounVerb(String nounVerb);
}
