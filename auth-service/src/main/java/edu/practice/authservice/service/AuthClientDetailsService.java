package edu.practice.authservice.service;

import edu.practice.authservice.domain.AuthClientDetails;
import edu.practice.authservice.repo.AuthClientRepository;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * a service interface to provide the details about an OAuth2 client
 */
@Service
public class AuthClientDetailsService implements ClientDetailsService {
    private final AuthClientRepository authClientRepository;

    public AuthClientDetailsService(AuthClientRepository authClientRepository) {
        this.authClientRepository = authClientRepository;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) {
        return authClientRepository
                .findClientByClientId(clientId)
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<AuthClientDetails> getAllClients(){
        return authClientRepository.findAll();
    }

    public AuthClientDetails addClient(AuthClientDetails clientDetails){
        return authClientRepository.save(clientDetails);
    }
}