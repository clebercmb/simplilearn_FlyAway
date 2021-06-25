package com.example.simplilearn.flyaway.modules.user.services;

import com.example.simplilearn.flyaway.modules.user.adapter.in.command.UserCommand;
import com.example.simplilearn.flyaway.modules.user.adapter.out.persistence.UserDao;
import com.example.simplilearn.flyaway.modules.user.domain.User;
import org.springframework.stereotype.Service;

@Service
public class FindUserByEmailService {

    private final UserDao userDao;


    public FindUserByEmailService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserCommand execute(String email) {

        User user = userDao.findByEmail(email);

        return user.getUserCommand();

    }
}
