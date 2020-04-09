package edu.practice.authservice.config.mongoDB;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "edu.microservices.authservice.repo")
public class MongoConfig {

}