package com.example.simplilearn.flyaway.modules.flight.services;

import com.example.simplilearn.flyaway.modules.flight.adapter.in.command.FlightCommand;
import com.example.simplilearn.flyaway.modules.flight.adapter.in.command.SearchFlightsCommand;
import com.example.simplilearn.flyaway.modules.flight.adapter.out.persistence.FlightDao;
import com.example.simplilearn.flyaway.modules.flight.domain.Flight;
import com.example.simplilearn.flyaway.modules.flight.dto.FlightDto;
import com.example.simplilearn.flyaway.modules.places.adapter.out.persistence.PlaceDao;
import com.example.simplilearn.flyaway.modules.places.domain.Place;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchFlightService {

    private final FlightDao flightDao;

    public SearchFlightService(FlightDao flightDao) {

        this.flightDao = flightDao;

    }

    public List<FlightDto> execute(SearchFlightsCommand searchCommand) {

        LocalDate departureTime = null;
        LocalDate returnTime = null;

        if(searchCommand.getDepartureTime() != null) {
            departureTime = LocalDate.parse(searchCommand.getDepartureTime());
        }

        if(searchCommand.getReturnTime() != null) {
            returnTime = LocalDate.parse(searchCommand.getReturnTime());
        }

        List<Flight> flightList = flightDao.searchFlights(
                searchCommand.getFrom(),
                searchCommand.getTo(),
                searchCommand.getNumberOfPassengers(),
                departureTime,
                returnTime
        );

        List<FlightDto> result = new ArrayList<>();
        flightList.forEach(f-> result.add(f.getFlightDto()));

        return result;
    }

}
