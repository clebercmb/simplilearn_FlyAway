package com.example.simplilearn.flyaway.modules.booking.adapter.out.persistence;

import com.example.simplilearn.flyaway.modules.booking.domain.Booking;
import com.example.simplilearn.flyaway.util.IDao;

import java.util.List;

public abstract class BookingDao extends IDao<Booking> {

    public abstract List<Booking> findBookingByUserId(Integer userId);
}
