package edu.practice.englishstudyservice.repos.grammar;

import edu.practice.englishstudyservice.domain.grammar.GrammarTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrammarTaskRepository extends JpaRepository<GrammarTask, Long> {
}
