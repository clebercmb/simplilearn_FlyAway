package com.example.simplilearn.flyaway.modules.places.services;

import com.example.simplilearn.flyaway.modules.places.adapter.in.command.PlaceCommand;
import com.example.simplilearn.flyaway.modules.places.adapter.out.persistence.PlaceDao;
import com.example.simplilearn.flyaway.modules.places.domain.Place;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReadAllPlacesService {

    private final PlaceDao placeDao;

    public ReadAllPlacesService(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }

    public List<PlaceCommand> execute() {
        Set<Place> placesSet = placeDao.readAll();



        List<PlaceCommand> placesList = new ArrayList<>();
        for(Place place : placesSet) {
            placesList.add( place.getPlaceCommand() );
        }

        //placesList = placesSet.stream().sorted( (p1,p2) ->p1.getName().compareTo(p2.getName())).collect(Collectors.toList());

        return placesList.stream().sorted( (p1, p2)  -> p1.getName().compareTo(p2.getName()) ).collect(Collectors.toList());
    }

}
