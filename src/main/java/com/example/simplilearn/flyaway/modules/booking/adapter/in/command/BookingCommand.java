package com.example.simplilearn.flyaway.modules.booking.adapter.in.command;

import com.example.simplilearn.flyaway.modules.booking.dto.PassengerDto;
import com.example.simplilearn.flyaway.modules.flight.dto.FlightDto;
import com.example.simplilearn.flyaway.modules.user.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class BookingCommand {

    private Integer bookingId;
    private Integer flightId;

    private List<PassengerDto> passengersList = new ArrayList<>();

    private FlightDto flightDto;
    private UserDto userDto;

    public BookingCommand() {
    }

    public BookingCommand(Integer bookingId, Integer flightId, List<PassengerDto> passengersList, FlightDto flightDto, UserDto userDto) {
        this.bookingId = bookingId;
        this.flightId = flightId;
        this.passengersList = passengersList;
        this.flightDto = flightDto;
        this.userDto = userDto;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public FlightDto getFlightDto() {
        return flightDto;
    }

    public void setFlightDto(FlightDto flightDto) {
        this.flightDto = flightDto;
    }

    public List<PassengerDto> getPassengersList() {
        return passengersList;
    }

    public void setPassengersList(
            List<PassengerDto> passengersList) {
        this.passengersList = passengersList;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
