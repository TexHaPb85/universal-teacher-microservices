package edu.practice.authservice.service;

import edu.practice.authservice.domain.User;
import edu.practice.authservice.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        existingUser.ifPresent(u -> {
            throw new IllegalArgumentException("User with username " + u.getUsername() + " already exists");
        });

        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        user.setActivated(Boolean.TRUE);

        // TODO send sms or email with code for activation
        // TODO other routines on account creation

        return userRepository.save(user);
    }
}
