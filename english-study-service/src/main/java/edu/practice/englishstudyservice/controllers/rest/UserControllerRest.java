package edu.practice.englishstudyservice.controllers.rest;

import edu.practice.englishstudyservice.services.UserDetailServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "users")
public class UserControllerRest {
    private final UserDetailServiceImpl userDetailService;

    public UserControllerRest(UserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }


}
