package edu.practice.englishstudyservice.controllers.rest;

import edu.practice.englishstudyservice.services.UserDetailServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "users")
public class GreetingRest {
    private final UserDetailServiceImpl userDetailService;

    public GreetingRest(UserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping("/")
    public ResponseEntity<String> main() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        UserDetails userDetails = null;
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            userDetails = (UserDetails) authentication.getPrincipal();

        }
        return ResponseEntity.ok(userDetails.getUsername());
    }

}
