package edu.practice.authservice.controller;

import edu.practice.authservice.model.domain.User;
import edu.practice.authservice.model.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "dto")
public class DtoController {
    @GetMapping
    public ResponseEntity<UserDto> getCurrent(@AuthenticationPrincipal User user){
        return ResponseEntity.ok(new UserDto(user));
    }
}
