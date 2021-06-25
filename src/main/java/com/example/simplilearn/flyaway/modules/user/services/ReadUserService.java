package com.example.simplilearn.flyaway.modules.user.services;

import com.example.simplilearn.flyaway.modules.user.adapter.in.command.UserCommand;
import com.example.simplilearn.flyaway.modules.user.adapter.out.persistence.UserDao;
import com.example.simplilearn.flyaway.modules.user.domain.User;
import org.springframework.stereotype.Service;

@Service
public class ReadUserService {

    private final UserDao userDao;


    public ReadUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserCommand execute(int id) {

        User user = userDao.read(id);

        return user.getPlaceCommand();

    }

}
