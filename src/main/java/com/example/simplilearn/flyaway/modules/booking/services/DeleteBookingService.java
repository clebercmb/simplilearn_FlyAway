package com.example.simplilearn.flyaway.modules.booking.services;

import com.example.simplilearn.flyaway.modules.booking.adapter.out.persistence.BookingDao;
import org.springframework.stereotype.Service;

@Service
public class DeleteBookingService {

    private final BookingDao bookingDao;

    public DeleteBookingService(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    public void execute(int id) {
        bookingDao.delete(id);
    }

}
