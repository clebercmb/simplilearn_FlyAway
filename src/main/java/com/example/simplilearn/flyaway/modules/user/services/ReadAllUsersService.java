package com.example.simplilearn.flyaway.modules.user.services;

import com.example.simplilearn.flyaway.modules.user.adapter.in.command.UserCommand;
import com.example.simplilearn.flyaway.modules.user.adapter.out.persistence.UserDao;
import com.example.simplilearn.flyaway.modules.user.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReadAllUsersService {

    private final UserDao userDao;

    public ReadAllUsersService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<UserCommand> execute() {
        Set<User> placesSet = userDao.readAll();



        List<UserCommand> placesList = new ArrayList<>();
        for(User user : placesSet) {
            placesList.add( user.getUserCommand() );
        }

        //placesList = placesSet.stream().sorted( (p1,p2) ->p1.getName().compareTo(p2.getName())).collect(Collectors.toList());

        return placesList.stream().sorted( (p1, p2)  -> p1.getName().compareTo(p2.getName()) ).collect(Collectors.toList());
    }

}
