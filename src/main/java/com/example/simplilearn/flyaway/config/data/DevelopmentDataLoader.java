package com.example.simplilearn.flyaway.config.data;

import com.example.simplilearn.flyaway.modules.places.adapter.out.persistence.PlaceDao;
import com.example.simplilearn.flyaway.modules.places.domain.Place;
import com.example.simplilearn.flyaway.modules.user.adapter.out.persistence.UserDao;
import com.example.simplilearn.flyaway.modules.user.domain.User;
import com.example.simplilearn.flyaway.util.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


//@Component
public class DevelopmentDataLoader extends DataLoader {

    private UserDao userDao;
    private PlaceDao placeDao;

    @Autowired
    public DevelopmentDataLoader(UserDao userDao, PlaceDao placeDao){
        this.userDao = userDao;
        this.placeDao = placeDao;
    }

    @Override
    public void loadEnvironmentSpecificData() {
        System.out.println("#######################************#loadEnvironmentSpecificData was called");

        Place place1 = placeDao.read(1);
        User user1 = userDao.read(1);
        User user2 = userDao.read(2);


        if(user1 == null)  {
            user1 = new User(1,"tom", "tom@gmail.com", "1234", 0);
            userDao.create(user1);
        }

        if(user2== null)  {
            user2 = new User(2,"hulk", "hulk@gmail.com", "1234", 1 );
            userDao.create(user2);
        }

        //Save Environment specific data here....
        //userDao.save(<some object>);
    }
}