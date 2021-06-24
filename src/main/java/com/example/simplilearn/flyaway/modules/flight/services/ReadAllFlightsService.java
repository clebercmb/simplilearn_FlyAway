package com.example.simplilearn.flyaway.modules.flight.services;

import com.example.simplilearn.flyaway.modules.flight.adapter.in.command.FlightCommand;
import com.example.simplilearn.flyaway.modules.flight.adapter.out.persistence.FlightDao;
import com.example.simplilearn.flyaway.modules.flight.domain.Flight;
import com.example.simplilearn.flyaway.modules.flight.dto.FlightDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service
public class ReadAllFlightsService {

    private final FlightDao flightDao;

    public ReadAllFlightsService(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    public ArrayList<FlightCommand> execute() {
        Set<Flight> flightsSet = flightDao.readAll();

        ArrayList<FlightCommand>  flightsList = new ArrayList<>();
        for(Flight flight: flightsSet) {
            flightsList.add( flight.getFlightCommand() );
        }

        return flightsList;
    }

}
