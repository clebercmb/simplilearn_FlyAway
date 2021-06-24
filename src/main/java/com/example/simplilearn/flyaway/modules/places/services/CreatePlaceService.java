package com.example.simplilearn.flyaway.modules.places.services;

import com.example.simplilearn.flyaway.modules.places.adapter.in.command.PlaceCommand;
import com.example.simplilearn.flyaway.modules.places.adapter.out.persistence.PlaceDao;
import com.example.simplilearn.flyaway.modules.places.domain.Place;
import com.example.simplilearn.flyaway.modules.places.dto.PlaceDto;
import org.springframework.stereotype.Service;

@Service
public class CreatePlaceService {

    private PlaceDao placeDao;

    public CreatePlaceService(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }

    public PlaceDto execute(PlaceCommand placeCommand) {

        System.out.println(placeCommand);

        Place place = new Place(placeCommand);

        place = placeDao.create(place);

        return place.getFlightDto();
    }

}
