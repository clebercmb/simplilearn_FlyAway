package com.example.simplilearn.flyaway.modules.booking.services;

import com.example.simplilearn.flyaway.modules.booking.adapter.in.command.BookingCommand;
import com.example.simplilearn.flyaway.modules.booking.adapter.out.persistence.BookingDao;
import com.example.simplilearn.flyaway.modules.booking.domain.Booking;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReadBookingByUserIdService {

    private final BookingDao bookingDao;

    public ReadBookingByUserIdService(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    public List<BookingCommand> execute(Integer userID) {
        List<Booking>  bookingList = bookingDao.findBookingByUserId(userID);

        List<BookingCommand> bookingCommandList = new ArrayList<>();

        for(Booking booking: bookingList) {
            bookingCommandList.add(booking.getBookingCommand());
        }

            return bookingCommandList;
    }

}
