package com.example.simplilearn.flyaway.modules.flight.adapter.out.persistence;

import com.example.simplilearn.flyaway.modules.flight.domain.Flight;
import com.example.simplilearn.flyaway.util.IDao;

import java.time.LocalDate;
import java.util.List;

public abstract class FlightDao extends IDao<Flight> {

    public abstract List<Flight> searchFlights(String from, String To, int numberOfPassengers, LocalDate departureDate, LocalDate returnDate);
}
