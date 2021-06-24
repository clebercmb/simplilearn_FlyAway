package com.example.simplilearn.flyaway.modules.flight.services;

import com.example.simplilearn.flyaway.modules.flight.adapter.in.command.FlightCommand;
import com.example.simplilearn.flyaway.modules.flight.adapter.out.persistence.FlightDao;
import com.example.simplilearn.flyaway.modules.flight.domain.Flight;
import com.example.simplilearn.flyaway.modules.flight.dto.FlightDto;
import com.example.simplilearn.flyaway.modules.places.adapter.out.persistence.PlaceDao;
import com.example.simplilearn.flyaway.modules.places.domain.Place;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CreateFlightService {

    private final FlightDao flightDao;
    private final PlaceDao placeDao;

    public CreateFlightService(FlightDao flightDao, PlaceDao placeDao) {
        this.flightDao = flightDao;
        this.placeDao = placeDao;
    }

    public FlightDto execute(FlightCommand flightCommand) {

        Place placeFrom = placeDao.read(Integer.parseInt(flightCommand.getFrom()));
        Place placeTo = placeDao.read(Integer.parseInt(flightCommand.getTo()));

        Flight flight = new Flight(flightCommand);
        flight.setFrom(placeFrom);
        flight.setTo(placeTo);

        flight = flightDao.create(flight);

        return flight.getFlightDto();
    }

}
