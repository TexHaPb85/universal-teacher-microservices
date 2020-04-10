package edu.practice.englishstudyservice.entities;

import org.springframework.security.crypto.password.PasswordEncoder;

public class RegistrationForm {
    private String username;
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