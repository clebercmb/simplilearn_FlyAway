package com.example.simplilearn.flyaway.modules.user.services;

import com.example.simplilearn.flyaway.modules.user.adapter.in.command.ChangePasswordCommand;
import com.example.simplilearn.flyaway.util.MessageStatus;
import com.example.simplilearn.flyaway.modules.user.adapter.out.persistence.UserDao;
import com.example.simplilearn.flyaway.modules.user.domain.User;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordService {

    private UserDao userDao;

    public ChangePasswordService(UserDao userDao) {
        this.userDao = userDao;
    }

    public MessageStatus execute(ChangePasswordCommand changePasswordCommand) {

        User hasUser = userDao.findByEmail(changePasswordCommand.getEmail());
        User userToChange = userDao.read(changePasswordCommand.getUserId());

        if(hasUser != null && hasUser.getUserId() != userToChange.getUserId() ) {
            return MessageStatus.EMAIL_ALREADY_USED;
        }

        if(changePasswordCommand.getPassword().length() == 0) {
            return MessageStatus.PASSWORD_MUST_BE_TYPED;
        }

        if(!changePasswordCommand.getPassword().equals(changePasswordCommand.getRepeatPassword())) {
            return MessageStatus.PASSWORD_DOES_NOT_MATCH;
        }

        userToChange.setEmail(changePasswordCommand.getEmail());
        userToChange.setPassword(changePasswordCommand.getPassword());
        userToChange.setName(changePasswordCommand.getName());

        User user = userDao.update(userToChange);

        return MessageStatus.SUCCESS_UPDATED;
    }

}
