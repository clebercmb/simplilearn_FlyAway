package com.example.simplilearn.flyaway.modules.booking.services;

import com.example.simplilearn.flyaway.modules.booking.adapter.in.command.BookingCommand;
import com.example.simplilearn.flyaway.modules.booking.adapter.out.persistence.BookingDao;
import com.example.simplilearn.flyaway.modules.booking.domain.Booking;
import com.example.simplilearn.flyaway.modules.booking.domain.Passenger;
import com.example.simplilearn.flyaway.modules.booking.dto.BookingDto;
import com.example.simplilearn.flyaway.modules.booking.dto.PassengerDto;
import com.example.simplilearn.flyaway.modules.flight.adapter.out.persistence.FlightDao;
import com.example.simplilearn.flyaway.modules.flight.domain.Flight;
import com.example.simplilearn.flyaway.modules.user.adapter.out.persistence.UserDao;
import com.example.simplilearn.flyaway.modules.user.domain.User;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CreateBookingService {

    private final BookingDao bookingDao;
    private final FlightDao flightDao;
    private final UserDao userDao;

    public CreateBookingService(BookingDao bookingDao, FlightDao flightDao, UserDao userDao) {
        this.bookingDao = bookingDao;
        this.flightDao = flightDao;
        this.userDao = userDao;
    }

    public BookingDto execute(BookingCommand bookingCommand) {

        Booking booking = new Booking();

        Flight flight = flightDao.read(bookingCommand.getFlightId());
        User user = userDao.read(bookingCommand.getUserDto().getUserId());

        booking.setFlight(flight);
        booking.setUser(user);

        for(PassengerDto passengerDto : bookingCommand.getPassengersList()) {
            booking.addPassenger(passengerDto.getPassenger());
        }

        booking = bookingDao.create(booking);

        return booking.getBookingDto();
    }

}
