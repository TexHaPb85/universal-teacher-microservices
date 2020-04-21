package edu.practice.englishstudyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EnglishStudyServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EnglishStudyServiceApplication.class, args);
    }
}
