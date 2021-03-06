package com.example.simplilearn.flyaway.modules.user.adapter.in.command;

import com.example.simplilearn.flyaway.modules.user.domain.Group;

public class UserCommand {

    private int userId;
    private String name;
    private String email;
    private String password;
    private int group;
    private String groupName;

    public UserCommand() {
    }

    public UserCommand(int userId, String name, String email, String password, int group) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.group = group;
        this.groupName = Group.getGroupName(group);
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
        this.groupName = Group.getGroupName(group);
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
