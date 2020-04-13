package edu.practice.englishstudyservice.controllers.rest;

import edu.practice.englishstudyservice.domain.User;
import edu.practice.englishstudyservice.services.UserDetailServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserControllerRest {
    private final UserDetailServiceImpl userDetailService;

    public UserControllerRest(UserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userDetailService.getUsers());
    }
}
