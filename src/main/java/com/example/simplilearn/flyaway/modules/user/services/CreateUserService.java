package com.example.simplilearn.flyaway.modules.user.services;

import com.example.simplilearn.flyaway.modules.user.adapter.in.command.UserCommand;
import com.example.simplilearn.flyaway.modules.user.adapter.out.persistence.UserDao;
import com.example.simplilearn.flyaway.modules.user.domain.User;
import com.example.simplilearn.flyaway.modules.user.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {

    private UserDao userDao;

    public CreateUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDto execute(UserCommand userCommand) {


        System.out.println(userCommand);
        userCommand.setGroup(2);

        User hasUser = userDao.findByEmail(userCommand.getEmail());
        if( hasUser != null ) {
            return null;
        }
        User user = new User(userCommand);

        user = userDao.create(user);

        return user.getUserDto();
    }

}
