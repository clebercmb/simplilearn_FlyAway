package com.example.simplilearn.flyaway.modules.user.services;

import com.example.simplilearn.flyaway.modules.user.adapter.out.persistence.UserDao;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserService {

    private final UserDao userDao;

    public DeleteUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void execute(int id) {
        userDao.delete(id);
    }

}
