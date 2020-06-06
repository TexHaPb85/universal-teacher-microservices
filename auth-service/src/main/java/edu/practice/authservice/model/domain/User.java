package edu.practice.authservice.model.domain;


import edu.practice.authservice.model.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "app_users")
public class User implements Serializable, UserDetails {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO) ід буде приходити з гугла, тому немає сенсу їх автогенерувати
    private String id;

    @Email
    private String email;
    //@JsonIgnore
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "prof_id")
    private UsrProfile profile;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public User(String id, @Email String email, String password, UsrProfile profile) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.profile = profile;
    }

    public User(@Email String email, String password, UsrProfile profile) {
        this.email = email;
        this.password = password;
        this.profile = profile;
    }

    public User() {
        this.id = "id of empty user";
        this.email = "emptyuser@gmail.com";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsrProfile getProfile() {
        return profile;
    }

    public void setProfile(UsrProfile profile) {
        this.profile = profile;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
