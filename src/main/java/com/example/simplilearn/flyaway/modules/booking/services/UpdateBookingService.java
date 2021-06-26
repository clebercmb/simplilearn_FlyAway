package com.example.simplilearn.flyaway.modules.booking.services;

import com.example.simplilearn.flyaway.modules.booking.adapter.in.command.BookingCommand;
import com.example.simplilearn.flyaway.modules.booking.adapter.out.persistence.BookingDao;
import com.example.simplilearn.flyaway.modules.booking.domain.Booking;
import com.example.simplilearn.flyaway.modules.booking.dto.BookingDto;
import org.springframework.stereotype.Service;

@Service
public class UpdateBookingService {

    private BookingDao bookingDao;

    public UpdateBookingService(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    public BookingDto execute(BookingCommand placeCommand) {

        System.out.println(placeCommand);

        Booking booking = new Booking(); //Booking(placeCommand);

        booking = bookingDao.update(booking);

        return booking.getBookingDto();
    }

}
