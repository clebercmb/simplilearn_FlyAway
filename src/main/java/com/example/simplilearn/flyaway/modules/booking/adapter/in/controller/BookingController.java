package com.example.simplilearn.flyaway.modules.booking.adapter.in.controller;

import com.example.simplilearn.flyaway.modules.booking.adapter.in.command.BookingCommand;
import com.example.simplilearn.flyaway.modules.booking.dto.BookingDto;
import com.example.simplilearn.flyaway.modules.booking.services.*;
import com.example.simplilearn.flyaway.modules.flight.adapter.in.command.FlightCommand;
import com.example.simplilearn.flyaway.modules.flight.services.ReadFlightService;
import com.example.simplilearn.flyaway.modules.places.adapter.in.command.PlaceCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookingController {

    CreateBookingService createBookingService;
    ReadAllBookingService readAllBookingService;
    DeleteBookingService deleteBookingService;
    ReadBookingService readBookingService;
    UpdateBookingService updateBookingService;

    ReadFlightService readFlightService;

    public BookingController(CreateBookingService createBookingService,
                             ReadAllBookingService readAllBookingService,
                             DeleteBookingService deleteBookingService,
                             ReadBookingService readBookingService,
                             UpdateBookingService updateBookingService,
                             ReadFlightService readFlightService) {
        this.createBookingService = createBookingService;
        this.readAllBookingService = readAllBookingService;
        this.deleteBookingService = deleteBookingService;
        this.readBookingService = readBookingService;
        this.updateBookingService = updateBookingService;
        this.readFlightService = readFlightService;
    }

    @RequestMapping("booking")
    //public String showBooking(@ModelAttribute("bookingCommand") BookingCommand booking, Model map, @RequestParam String id, @RequestParam String passengers) {
    public String showBooking(@ModelAttribute("bookingCommand") BookingCommand booking, Model map, @RequestParam String id, @RequestParam String passengers) {

        System.out.println("show Booking");
        FlightCommand flightCommand = readFlightService.execute(Integer.parseInt(id));
        map.addAttribute("flight", flightCommand);
        map.addAttribute("numberOfPassengers", Integer.parseInt(passengers));
        return "booking";
    }

    @RequestMapping(value = "create-booking", method = RequestMethod.POST)
    public String post(@ModelAttribute("bookingCommand") BookingCommand booking, Model map) {

        return "redirect:/booking-tickets";
    }


}
