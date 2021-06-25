package com.example.simplilearn.flyaway.modules.user.services;

import com.example.simplilearn.flyaway.modules.user.adapter.in.command.UserCommand;
import com.example.simplilearn.flyaway.modules.user.adapter.out.persistence.UserDao;
import com.example.simplilearn.flyaway.modules.user.domain.User;
import com.example.simplilearn.flyaway.modules.user.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserService {

    private UserDao userDao;

    public UpdateUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDto execute(UserCommand userCommand) {

        System.out.println(userCommand);

        User user = new User(userCommand);

        user = userDao.update(user);

        return user.getPlaceDto();
    }

}
