package edu.practice.authservice.repo;


import edu.practice.authservice.model.domain.UsrProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsrProfileRepository extends JpaRepository<UsrProfile, String> {
}
