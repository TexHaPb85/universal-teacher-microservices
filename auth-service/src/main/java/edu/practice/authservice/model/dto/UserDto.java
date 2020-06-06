package edu.practice.authservice.model.dto;

import edu.practice.authservice.model.domain.User;

import java.io.Serializable;

public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String username;
    private Long exp;
    private String photoUrl;

    public UserDto(String id, String username, Long exp, String photoUrl) {
        this.id = id;
        this.username = username;
        this.exp = exp;
        this.photoUrl = photoUrl;
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.exp = user.getProfile().getExperience();
        this.photoUrl = user.getProfile().getPhotoURL();
    }

    public UserDto() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getExp() {
        return exp;
    }

    public void setExp(Long exp) {
        this.exp = exp;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}