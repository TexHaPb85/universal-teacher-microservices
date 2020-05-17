package edu.practice.accountservice.service;

import edu.practice.accountservice.dto.UserDto;
import edu.practice.accountservice.dto.UserRegistrationDto;

public interface AccountService {
    /**
     * Invokes Auth Service user creation
     *
     * @param user
     * @return created account
     */
    UserDto create(UserRegistrationDto user);
}
