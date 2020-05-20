package edu.practice.authservice.controller;

import edu.practice.authservice.model.domain.AuthClientDetails;
import edu.practice.authservice.service.AuthClientDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "clients/registration")
public class ClientRegistrationController {

    private AuthClientDetailsService clientDetailsService;

    public ClientRegistrationController(AuthClientDetailsService clientDetailsService) {
        this.clientDetailsService = clientDetailsService;
    }

    @GetMapping
    public ResponseEntity<List<AuthClientDetails>> getAllClients(){
        return ResponseEntity
                .ok()
                .body(clientDetailsService.getAllClients());
    }

    @PostMapping
    public ResponseEntity<AuthClientDetails> addClient(@RequestBody AuthClientDetails client){
        return ResponseEntity
                .ok()
                .body(clientDetailsService.addClient(client));
    }
}
