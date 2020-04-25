package edu.practice.authservice.domain;


import edu.practice.authservice.enums.Authorities;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User implements UserDetails {
    @Id
    private String id;
    private String username;
    private String password;
    private boolean activated;
    private String activationKey;
    private String resetPasswordKey;

    //private Set<Authorities> authorities = new HashSet<>();

    public User(String id, String username, String password, boolean activated, String activationKey, String resetPasswordKey) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.activated = activated;
        this.activationKey = activationKey;
        this.resetPasswordKey = resetPasswordKey;
        //this.authorities = authorities;
    }

    public User() {
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return List.of(Authorities.ROLE_USER);
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() { // expire - истекать
        return true;//we don`t use session, so account will never expired
    }

    /**
     * Indicates whether the user is locked or unlocked.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) has expired.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }


//    public void setAuthorities(Set<Authorities> authorities) {
//        this.authorities = authorities;
//    }
}
