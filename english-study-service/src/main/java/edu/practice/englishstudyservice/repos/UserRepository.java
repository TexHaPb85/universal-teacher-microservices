package edu.practice.englishstudyservice.repos;

import edu.practice.englishstudyservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
