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
public class ReadAllBookingService {

    private final BookingDao bookingDao;

    public ReadAllBookingService(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    public List<BookingCommand> execute() {
        Set<Booking> placesSet = bookingDao.readAll();



        List<BookingCommand> placesList = new ArrayList<>();
        for(Booking booking : placesSet) {
            //placesList.add( booking.getBookingCommand() );
        }

        //placesList = placesSet.stream().sorted( (p1,p2) ->p1.getName().compareTo(p2.getName())).collect(Collectors.toList());

        //return placesList.stream().sorted( (b1, b2)  -> b1.getFlightDto().getDepartureTime().compareTo(b2.getFlightDto().getDepartureTime())  ).collect(Collectors.toList());
        return null;
    }

}
