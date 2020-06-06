package edu.practice.authservice.service.usr;


import edu.practice.authservice.model.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();

    User getUserById(String id);

    User saveUser(User user);

    void deleteUserById(String userId);

    User editUserById(String userId, User user);
}
