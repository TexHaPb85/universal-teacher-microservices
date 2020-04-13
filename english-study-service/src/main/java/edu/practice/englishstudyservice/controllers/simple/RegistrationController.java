package edu.practice.englishstudyservice.controllers.simple;

import edu.practice.englishstudyservice.domain.RegistrationForm;
import edu.practice.englishstudyservice.domain.User;
import edu.practice.englishstudyservice.repos.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping
    public String registerForm() {
        return "registration";
    }
    @PostMapping
    public String processRegistration(RegistrationForm form) {
        User u = form.toUser(passwordEncoder);
        System.out.println(u);
        userRepo.save(u);
        return "redirect:/login";
    }
}