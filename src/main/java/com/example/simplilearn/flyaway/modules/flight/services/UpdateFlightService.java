package com.example.simplilearn.flyaway.modules.flight.services;

import com.example.simplilearn.flyaway.modules.flight.adapter.in.command.FlightCommand;
import com.example.simplilearn.flyaway.modules.flight.adapter.out.persistence.FlightDao;
import com.example.simplilearn.flyaway.modules.flight.domain.Flight;
import com.example.simplilearn.flyaway.modules.flight.dto.FlightDto;
import org.springframework.stereotype.Service;

@Service
public class UpdateFlightService {

    private FlightDao flightDao;

    public UpdateFlightService(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    public FlightDto execute(FlightCommand flightCommand) {

        System.out.println(flightCommand);

        Flight flight = new Flight(flightCommand);

        flight = flightDao.update(flight);

        return flight.getFlightDto();
    }

}
