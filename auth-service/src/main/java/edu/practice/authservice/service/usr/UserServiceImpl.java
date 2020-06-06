package edu.practice.authservice.service.usr;


import edu.practice.authservice.exceptions.UserNotFoundException;
import edu.practice.authservice.model.domain.User;
import edu.practice.authservice.repo.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(String id) {
        return repository
                .findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteUserById(String userId) {
        repository.deleteById(userId);
    }

    @Override
    public User editUserById(String userId, User user) {
        User userFromDB = getUserById(userId);
        BeanUtils.copyProperties(user,userFromDB,"id");
        return repository.save(userFromDB);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return repository.findByEmail(s);
    }
}
