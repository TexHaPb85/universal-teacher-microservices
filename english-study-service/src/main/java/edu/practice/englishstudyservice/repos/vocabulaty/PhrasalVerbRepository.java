package edu.practice.englishstudyservice.repos.vocabulaty;

import edu.practice.englishstudyservice.domain.vocabulary.PhrasalVerb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhrasalVerbRepository extends JpaRepository<PhrasalVerb, Long> {
    List<PhrasalVerb> findPhrasalVerbsByVerb(String verb);

    List<PhrasalVerb> findByOrderByVerbAsc();
}
