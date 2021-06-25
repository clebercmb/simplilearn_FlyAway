package com.example.simplilearn.flyaway.modules.user.adapter.in.command;


public class ChangePasswordCommand {

    private int userId;
    private String name;
    private String email;
    private String password;
    private String repeatPassword;

    public ChangePasswordCommand() {
    }

    public ChangePasswordCommand(int userId, String name, String email, String password, String repeatPassword) {
        this.name = name;
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
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

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
