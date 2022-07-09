package com.tutrit.tgbot.example.bean;

import com.tutrit.tgbot.example.constants.Role;

import java.util.Objects;

public class User {
    private Role userRole;
    private Long tgId;
    private String tgFirstName;
    private String tgLastName;
    private String tgUserName;

    public User(Role userRole, Long tgId, String tgFirstName, String tgLastName, String tgUserName) {
        this.userRole = userRole;
        this.tgId = tgId;
        this.tgFirstName = tgFirstName;
        this.tgLastName = tgLastName;
        this.tgUserName = tgUserName;
    }

    public User() {
    }

    public Role getUserRole() {
        return userRole;
    }

    public Long getTgId() {
        return tgId;
    }

    public String getTgFirstName() {
        return tgFirstName;
    }

    public String getTgLastName() {
        return tgLastName;
    }

    public String getTgUserName() {
        return tgUserName;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public void setTgId(Long tgId) {
        this.tgId = tgId;
    }

    public void setTgFirstName(String tgFirstName) {
        this.tgFirstName = tgFirstName;
    }

    public void setTgLastName(String tgLastName) {
        this.tgLastName = tgLastName;
    }

    public void setTgUserName(String tgUserName) {
        this.tgUserName = tgUserName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getUserRole() == user.getUserRole() && getTgId().equals(user.getTgId()) && getTgFirstName().equals(user.getTgFirstName()) && getTgLastName().equals(user.getTgLastName()) && getTgUserName().equals(user.getTgUserName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserRole(), getTgId(), getTgFirstName(), getTgLastName(), getTgUserName());
    }
}
