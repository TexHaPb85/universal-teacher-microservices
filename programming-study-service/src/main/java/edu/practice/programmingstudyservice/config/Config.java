package edu.practice.programmingstudyservice.config;


import edu.practice.programmingstudyservice.entities.UserDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class Config {
    @Bean
    public Random getRandomObj(){
        return new Random();
    }

    @Bean
    public UserDTO getPrincipalUserDTO(){
        return new UserDTO("101545368102071580793","Kelbasik",0);
    }
}
