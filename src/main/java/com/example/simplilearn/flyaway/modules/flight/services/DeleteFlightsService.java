package com.example.simplilearn.flyaway.modules.flight.services;

import com.example.simplilearn.flyaway.modules.flight.adapter.in.command.FlightCommand;
import com.example.simplilearn.flyaway.modules.flight.adapter.out.persistence.FlightDao;
import com.example.simplilearn.flyaway.modules.flight.domain.Flight;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service
public class DeleteFlightsService {

    private final FlightDao flightDao;

    public DeleteFlightsService(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    public void execute(int id) {
        flightDao.delete(id);
    }

}
