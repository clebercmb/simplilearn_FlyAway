package com.example.simplilearn.flyaway.modules.places.services;

import com.example.simplilearn.flyaway.modules.places.adapter.in.command.PlaceCommand;
import com.example.simplilearn.flyaway.modules.places.adapter.out.persistence.PlaceDao;
import com.example.simplilearn.flyaway.modules.places.domain.Place;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service
public class ReadAllPlacesService {

    private final PlaceDao placeDao;

    public ReadAllPlacesService(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }

    public ArrayList<PlaceCommand> execute() {
        Set<Place> flightsSet = placeDao.readAll();

        ArrayList<PlaceCommand>  flightsList = new ArrayList<>();
        for(Place place : flightsSet) {
            flightsList.add( place.getFlightCommand() );
        }

        return flightsList;
    }

}
