package com.example.simplilearn.flyaway.modules.flight.services;

import com.example.simplilearn.flyaway.modules.flight.adapter.in.command.FlightCommand;
import com.example.simplilearn.flyaway.modules.flight.adapter.out.persistence.FlightDao;
import com.example.simplilearn.flyaway.modules.flight.domain.Flight;
import org.springframework.stereotype.Service;

@Service
public class ReadFlightService {

    private final FlightDao flightDao;

    public ReadFlightService(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    public FlightCommand execute(int id) {

        Flight flight = flightDao.read(id);
        return flight.getFlightCommand();

    }

}
