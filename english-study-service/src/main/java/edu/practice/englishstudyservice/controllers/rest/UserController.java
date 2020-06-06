package edu.practice.englishstudyservice.controllers.rest;


import edu.practice.englishstudyservice.domain.dto.UserDTO;
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
