package edu.practice.authservice.config;

import edu.practice.authservice.model.domain.User;
import edu.practice.authservice.model.domain.UsrProfile;
import edu.practice.authservice.repo.UserRepository;
import edu.practice.authservice.service.usr.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.time.LocalDateTime;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    public WebSecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .antMatcher("/**").authorizeRequests()
                    .antMatchers("/", "/login**", "/js/**", "/error**").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .logout().logoutSuccessUrl("/").permitAll()
                .and()
                    .csrf()
                        .disable();
    }

/*    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new GoogleUrlAuthenticationSuccessHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }*/

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }


    /**
     * during google authorization we are looking for user with the same Id im DB,
     * if we haven`t found it, we get info from google account add it to db
     */
    @Bean
    public PrincipalExtractor principalExtractor(UserRepository userRepository) {
        return map -> {
            String id = (String) map.get("sub");
            User loggedInUser = userRepository.findById(id).orElseGet(() -> {
                User newUser = new User();
                UsrProfile newProfile = new UsrProfile();

                newUser.setId(id);
                newUser.setEmail((String) map.get("email"));

                newProfile.setId(id);
                newProfile.setLogin((String) map.get("name"));
                newProfile.setPhotoURL((String) map.get("picture"));
                newProfile.setLocale((String) map.get("locale"));

                newUser.setProfile(newProfile);
                return userRepository.save(newUser);
            });

            loggedInUser.getProfile().setLastVisitDate(LocalDateTime.now());
            return loggedInUser;
        };
    }
}

