package com.example.simplilearn.flyaway.modules.user.domain;


import com.example.simplilearn.flyaway.modules.user.adapter.in.command.UserCommand;
import com.example.simplilearn.flyaway.modules.user.dto.UserDto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;

    @Column(name="name", nullable = false, length = 30)
    private String name;

    @Column(name="email", nullable = false, length = 30)
    private String email;

    @Column(name="password", nullable = false, length = 30)
    private String password;

    @Column(name="users_group")
    private int group;



    public User() {
    }

    public User(UserCommand userCommand) {
        this.userId = userCommand.getUserId();
        this.name = userCommand.getName();
        this.email = userCommand.getEmail();
        this.password = userCommand.getPassword();
        this.group = userCommand.getGroup();
    }


    public User(int userId, String name, String email, String password, int group) {
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

    public UserDto getUserDto() {

        UserDto userDto = new UserDto();
        userDto.setUserId(getUserId());
        userDto.setName(getName());
        userDto.setEmail(getEmail());
        userDto.setPassword(getPassword());
        userDto.setGroup( getGroup() );

        return userDto;
    }

    public UserCommand getUserCommand() {

        UserCommand userDto = new UserCommand();
        userDto.setUserId(getUserId());
        userDto.setName(getName());
        userDto.setEmail(getEmail());
        userDto.setPassword(getPassword());
        userDto.setGroup( getGroup());

        return userDto;
    }



}
