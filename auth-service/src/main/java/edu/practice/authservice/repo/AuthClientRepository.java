package edu.practice.authservice.repo;

import edu.practice.authservice.domain.AuthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthClientRepository extends JpaRepository<AuthClientRepository,String> {
    Optional<AuthClientDetails> findByClientId(String clientId);
}
