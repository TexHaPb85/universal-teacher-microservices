package edu.practice.programmingstudyservice.controller;

import edu.practice.programmingstudyservice.entities.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserDTO userDTO;

    public UserController(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @GetMapping
    public ResponseEntity<UserDTO> getResponseEntity(){
        return ResponseEntity.ok(userDTO);
    }
}
