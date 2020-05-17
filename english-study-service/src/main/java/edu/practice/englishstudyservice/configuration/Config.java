package edu.practice.englishstudyservice.configuration;

import edu.practice.englishstudyservice.domain.dto.UserDTO;
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
        return new UserDTO();//TODO
    }
}
