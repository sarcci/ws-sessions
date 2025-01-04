package com.example.wsproject.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")

public class User {
    
    @Id
    @Column(name = "userID", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name="email", length = 255)
    private String email;

    @Column(name="password", length = 255)
    private String password;

    public User() {}

    public User(int userID, String name, String email, String password) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [userID=" + userID + ", name=" + name + ", email=" + email + ", password=" + password + "]";
    }

    
    

    

    
}
