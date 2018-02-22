package com.zero4kevin.spring.examples.security.DTO;


import java.util.List;

/**
 * Created by xi1zhang on 2018/2/14.
 */
public class MyUser {

    private int id;

    private String accountName;
    private String firstName;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    private String lastName;
    private String password;
    private String confirmPassword;
    private String email;
    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String>  role) {
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
