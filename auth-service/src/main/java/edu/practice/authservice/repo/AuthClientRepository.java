package edu.practice.authservice.repo;

import edu.practice.authservice.model.domain.AuthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthClientRepository extends JpaRepository<AuthClientDetails,String> {
    Optional<AuthClientDetails> findClientByClientId(String clientId);
}
