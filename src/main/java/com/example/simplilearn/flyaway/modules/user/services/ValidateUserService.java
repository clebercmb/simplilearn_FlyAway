package com.example.simplilearn.flyaway.modules.user.services;

import com.example.simplilearn.flyaway.modules.user.adapter.in.command.UserCommand;
import com.example.simplilearn.flyaway.modules.user.adapter.out.persistence.UserDao;
import com.example.simplilearn.flyaway.modules.user.domain.User;
import com.example.simplilearn.flyaway.modules.user.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class ValidateUserService {

    private final UserDao userDao;

    public ValidateUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean execute(UserCommand userCommand) {

        System.out.println(userCommand);

        User user = new User(userCommand);

        user = userDao.findByEmail(user.getEmail());

        return user != null && user.getPassword().equals(userCommand.getPassword()) && user.getEmail().equals(userCommand.getEmail());

    }

}
