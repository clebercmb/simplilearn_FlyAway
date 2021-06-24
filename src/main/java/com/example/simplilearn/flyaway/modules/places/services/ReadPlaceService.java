package com.example.simplilearn.flyaway.modules.places.services;

import com.example.simplilearn.flyaway.modules.places.adapter.in.command.PlaceCommand;
import com.example.simplilearn.flyaway.modules.places.adapter.out.persistence.PlaceDao;
import com.example.simplilearn.flyaway.modules.places.domain.Place;
import org.springframework.stereotype.Service;

@Service
public class ReadPlaceService {

    private final PlaceDao placeDao;


    public ReadPlaceService(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }

    public PlaceCommand execute(int id) {

        Place place = placeDao.read(id);

        return place.getPlaceCommand();

    }

}
