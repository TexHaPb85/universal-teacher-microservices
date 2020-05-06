package edu.practice.authservice.controller;

import edu.practice.authservice.domain.User;
import edu.practice.authservice.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "users/registration")
public class UserRegistrationController {
    private final CustomUserDetailsService userDetailsService;

    public UserRegistrationController(@Autowired CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity
                .ok()
                .body(userDetailsService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity
                .ok()
                .body(userDetailsService.addUser(user));
    }
}
