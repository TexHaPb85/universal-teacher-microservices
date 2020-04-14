package edu.practice.englishstudyservice.controllers.simple;

import edu.practice.englishstudyservice.domain.serving.RegistrationForm;
import edu.practice.englishstudyservice.domain.User;
import edu.practice.englishstudyservice.repos.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
    public String registerForm(Model model) {
        model.addAttribute("formReg", new RegistrationForm());
        return "registration";
    }

    @PostMapping
    public String processRegistration(@Valid RegistrationForm formReg, Errors errors) {
        if (errors.hasErrors()){
            return "redirect:/register";//bug for fix
        }
        User u = formReg.toUser(passwordEncoder);
        System.out.println(u);
        userRepo.save(u);
        return "redirect:/login";
    }
}