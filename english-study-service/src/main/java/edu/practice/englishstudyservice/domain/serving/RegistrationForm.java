package edu.practice.englishstudyservice.domain.serving;

import edu.practice.englishstudyservice.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegistrationForm {
    @NotBlank(message = "username is not specified")
    @Size(min = 3, max = 15, message = "Username must contain at least 3 and at most 15 characters")
    private String username;
    @NotBlank(message = "password is not specified")
    @Size(min = 3, max = 15, message = "Password must contain at least 3 and at most 15 characters")
    private String password;
    private String phone;

    public RegistrationForm(String username, String password, String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public RegistrationForm() {
    }

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(
                username, passwordEncoder.encode(password), phone);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}