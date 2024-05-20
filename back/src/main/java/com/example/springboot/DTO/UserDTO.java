package com.example.springboot.DTO;

import com.example.springboot.model.User;

public class UserDTO {
    private Integer id;
    private String email;
    private String password;
    private String username;

    private String firstname;
    private String lastname;

    public UserDTO(Integer id, String email, String password, String username, String firstname, String lastname) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public UserDTO() {
    }

    public UserDTO(User existingUser) {
        this.id = existingUser.getId();
        this.email = existingUser.getEmail();
        this.password = existingUser.getPassword();
        this.username = existingUser.getUsername();
        this.firstname = existingUser.getFirstname();
        this.lastname = existingUser.getLastname();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}
