package com.example.simplilearn.flyaway.modules.user.dto;

import com.example.simplilearn.flyaway.modules.user.adapter.in.command.UserCommand;
import com.example.simplilearn.flyaway.modules.user.domain.Group;
import com.example.simplilearn.flyaway.modules.user.domain.User;

public class UserDto {

    private int userId;
    private String name;
    private String email;
    private String password;
    private int group;

    public UserDto() {
    }

    public UserDto(UserCommand userCommand) {
        this.userId = userCommand.getUserId();
        this.name = userCommand.getName();
        this.email = userCommand.getEmail();
        this.password = userCommand.getPassword();
        this.group = userCommand.getGroup() ;
    }


    public UserDto(int userId, String name, String email, String password, int group) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.group = group;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public User getUser() {
        User user = new User();
        user.setUserId(this.userId);
        user.setName(this.name);
        user.setEmail(this.email);
        user.setGroup(this.group);
        user.setPassword(this.password);
        return user;
    }
}
