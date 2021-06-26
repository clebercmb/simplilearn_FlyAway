package com.example.simplilearn.flyaway.modules.booking.dto;

import com.example.simplilearn.flyaway.modules.booking.domain.Booking;
import com.example.simplilearn.flyaway.modules.booking.domain.Passenger;
import com.example.simplilearn.flyaway.modules.flight.dto.FlightDto;
import com.example.simplilearn.flyaway.modules.user.dto.UserDto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookingDto {

    private int bookingId;
    private FlightDto flight;
    private UserDto user;
    private List<PassengerDto> passengers;

    public BookingDto() {
    }

    public BookingDto(int bookingId, FlightDto flight, UserDto user, List<PassengerDto> passengers) {
        this.bookingId = bookingId;
        this.flight = flight;
        this.user = user;
        this.passengers = passengers;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public FlightDto getFlight() {
        return flight;
    }

    public void setFlight(FlightDto flight) {
        this.flight = flight;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public List<PassengerDto> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerDto> passengers) {
        this.passengers = passengers;
    }

    public Booking getBooking() {
        Booking booking = new Booking();

        booking.setBookingId(this.bookingId);
        booking.setFlight(this.flight.getFlight());
        booking.setUser(this.user.getUser());

        Set<Passenger> passengers = new HashSet<>();

        return booking;
    }

}
