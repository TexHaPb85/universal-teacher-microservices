package edu.practice.authservice;

import edu.practice.authservice.domain.AuthClientDetails;
import edu.practice.authservice.domain.User;
import edu.practice.authservice.enums.Authorities;
import edu.practice.authservice.repo.AuthClientRepository;
import edu.practice.authservice.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class EnterEntryToDBTest {
    @Autowired
    private AuthClientRepository authClientRepository;
    @Autowired
    private UserRepository userRepository;

    //@Test
    public void addClient(){
        AuthClientDetails clientDetails = new AuthClientDetails();
        clientDetails.setId("english-study-service");
        clientDetails.setClientId("english-study-service");
        clientDetails.setClientSecret("1234");//("$2a$10$fWNTd3H.u7G/aNROVQSifebOkZ2xzU5nUPOCI2Ld42M8E25/ljJqK");
        clientDetails.setScopes("ui");
        clientDetails.setGrantTypes("refresh_token,password");
        System.out.println(authClientRepository.save(clientDetails));

        Set<Authorities> authorities = new HashSet<>();
        authorities.add(Authorities.ROLE_USER);

        //System.out.println(authClientRepository.getOne("client1"));

        User user = new User();
        user.setId("u1");
        user.setActivated(true);
        user.setPassword("1234");
        user.setUsername("randomuser");
        System.out.println(userRepository.save(user));
        System.out.println("\n"+userRepository.getOne("u1"));
    }

    @Test
    public void uTest(){
        System.out.println(userRepository.findAll());
        System.out.println(authClientRepository.findAll());
    }
}

//insert into auth_client_details (access_token_validity, additional_information, client_id, client_secret, grant_types, redirect_uris, refresh_token_validity, resources, scopes, id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)