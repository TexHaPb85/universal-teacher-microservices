package edu.practice.authservice.model.enums;

import org.springframework.security.core.GrantedAuthority;

/**
 * This enum is responsible to define the authorities of our auth service and it implements the GrantedAuthority
 * interface which represents an authority granted to an Authentication object.
 */
public enum Role implements GrantedAuthority {
    ROLE_ADMIN,
    ROLE_USER,
    ROLE_TEACHER;

    @Override
    public String getAuthority() {
        return name();
    }
}
