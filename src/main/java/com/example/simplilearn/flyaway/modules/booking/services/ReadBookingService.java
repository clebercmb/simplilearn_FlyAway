package com.example.simplilearn.flyaway.modules.booking.services;

import com.example.simplilearn.flyaway.modules.booking.adapter.in.command.BookingCommand;
import com.example.simplilearn.flyaway.modules.booking.adapter.out.persistence.BookingDao;
import com.example.simplilearn.flyaway.modules.booking.domain.Booking;
import org.springframework.stereotype.Service;

@Service
public class ReadBookingService {

    private final BookingDao bookingDao;


    public ReadBookingService(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    public BookingCommand execute(int id) {

        Booking booking = bookingDao.read(id);

        return null; //booking.getBookingCommand();

    }

}
