package edu.practice.authservice.controller;

import edu.practice.authservice.model.domain.User;
import edu.practice.authservice.service.usr.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AllUsersController {
    private final UserServiceImpl userService;

    public AllUsersController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("users")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PatchMapping("users/{userID}")
    public ResponseEntity<User> updateUser(@PathVariable String userID, @RequestBody User user) {
        return ResponseEntity.ok(userService.editUserById(userID, user));
    }
}
