package edu.practice.programmingstudyservice.entities;

public class UserDTO {
    private String userID;
    private String userName;
    private int exp;

    public UserDTO(String userID, String userName, int exp) {
        this.userID = userID;
        this.userName = userName;
        this.exp = exp;
    }

    public UserDTO() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
