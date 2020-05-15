package edu.practice.authservice.service;


import edu.practice.authservice.domain.User;
import edu.practice.authservice.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The UserDetailsService interface is used to retrieve(extract,receive) user-related data.
 * It has one method named loadUserByUsername() which can be overridden to customize the process of finding the user.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("username:" + s));
    }
}
