package com.example.simplilearn.flyaway.modules.booking.services;

import com.example.simplilearn.flyaway.modules.booking.adapter.in.command.BookingCommand;
import com.example.simplilearn.flyaway.modules.booking.adapter.out.persistence.BookingDao;
import com.example.simplilearn.flyaway.modules.booking.domain.Booking;
import com.example.simplilearn.flyaway.modules.booking.dto.BookingDto;
import org.springframework.stereotype.Service;

@Service
public class CreateBookingService {

    private BookingDao bookingDao;

    public CreateBookingService(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    public BookingDto execute(BookingCommand bookingCommand) {

        Booking booking = new Booking();//new Booking(bookingCommand);

        booking = bookingDao.create(booking);

        return booking.getBookingDto();
    }

}
