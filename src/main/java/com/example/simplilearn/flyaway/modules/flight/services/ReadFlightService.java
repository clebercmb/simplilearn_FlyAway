package com.example.simplilearn.flyaway.modules.flight.services;

import com.example.simplilearn.flyaway.modules.flight.adapter.in.command.FlightCommand;
import com.example.simplilearn.flyaway.modules.flight.adapter.out.persistence.FlightDao;
import com.example.simplilearn.flyaway.modules.flight.domain.Flight;
import com.example.simplilearn.flyaway.modules.places.adapter.in.command.PlaceCommand;
import com.example.simplilearn.flyaway.modules.places.adapter.out.persistence.PlaceDao;
import com.example.simplilearn.flyaway.modules.places.domain.Place;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReadFlightService {

    private final FlightDao flightDao;
    private final PlaceDao placeDao;

    public ReadFlightService(FlightDao flightDao, PlaceDao placeDao) {

        this.flightDao = flightDao;
        this.placeDao = placeDao;
    }

    public FlightCommand execute(int id) {

        Flight flight = flightDao.read(id);
        FlightCommand flightCommand = flight.getFlightCommand();

        Set<Place> placesSet = placeDao.readAll();
        List<PlaceCommand> placesFromList = new ArrayList<>();
        List<PlaceCommand> placesToList = new ArrayList<>();

        for(Place place : placesSet) {
            PlaceCommand placeFromCommand = place.getPlaceCommand();
            PlaceCommand placeToCommand = place.getPlaceCommand();
            if(place.getPlaceId() == flight.getFrom().getPlaceId() ) {
                placeFromCommand.activeSelected();
            }

            if(place.getPlaceId() == flight.getTo().getPlaceId() ) {
                placeToCommand.activeSelected();
            }

            placesFromList.add(placeFromCommand );
            placesToList.add(placeToCommand );
        }

        flightCommand.setPlaceFromList(placesFromList.stream().sorted( (p1, p2)  -> p1.getName().compareTo(p2.getName()) ).collect(Collectors.toList()));
        flightCommand.setPlaceToList(placesToList.stream().sorted( (p1, p2)  -> p1.getName().compareTo(p2.getName()) ).collect(Collectors.toList()));

        return flightCommand;

    }

}
