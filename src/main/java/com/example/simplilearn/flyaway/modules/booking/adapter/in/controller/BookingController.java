package com.example.simplilearn.flyaway.modules.booking.adapter.in.controller;

import com.example.simplilearn.flyaway.modules.booking.adapter.in.command.BookingCommand;
import com.example.simplilearn.flyaway.modules.booking.services.*;
import com.example.simplilearn.flyaway.modules.flight.adapter.in.command.FlightCommand;
import com.example.simplilearn.flyaway.modules.flight.services.ReadFlightService;
import com.example.simplilearn.flyaway.modules.user.adapter.in.command.UserCommand;
import com.example.simplilearn.flyaway.modules.user.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BookingController {

    private final CreateBookingService createBookingService;
    private final ReadAllBookingService readAllBookingService;
    private final DeleteBookingService deleteBookingService;
    private final ReadBookingService readBookingService;
    private final UpdateBookingService updateBookingService;

    private final ReadFlightService readFlightService;
    private final ReadBookingByUserIdService readBookingByUserIdService;

    public BookingController(CreateBookingService createBookingService,
                             ReadAllBookingService readAllBookingService,
                             DeleteBookingService deleteBookingService,
                             ReadBookingService readBookingService,
                             UpdateBookingService updateBookingService,
                             ReadFlightService readFlightService, ReadBookingByUserIdService readBookingByUserIdService) {
        this.createBookingService = createBookingService;
        this.readAllBookingService = readAllBookingService;
        this.deleteBookingService = deleteBookingService;
        this.readBookingService = readBookingService;
        this.updateBookingService = updateBookingService;
        this.readFlightService = readFlightService;
        this.readBookingByUserIdService = readBookingByUserIdService;
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
    public String post(@ModelAttribute("bookingCommand") BookingCommand booking, Model map, HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        UserCommand user= (UserCommand) session.getAttribute("user");

        user = new UserCommand();
        user.setUserId(1);

        booking.setUserDto(new UserDto(user));

        createBookingService.execute(booking);

        return "redirect:/booking-tickets";
    }


    @RequestMapping("booking-tickets")
    public String showBookingTickets(Model map, HttpServletRequest request) {
        System.out.println("showBookingTickets");

        HttpSession session = request.getSession(false);
        UserCommand user= (UserCommand) session.getAttribute("user");

        user = new UserCommand();
        user.setUserId(1);

        List<BookingCommand> bookingCommandList = readBookingByUserIdService.execute(user.getUserId());

        map.addAttribute("bookingList", bookingCommandList);

        return "bookingTickets";
    }

    @RequestMapping("deleteBooking")  // default GET
    public String delete(@RequestParam String id) {

        deleteBookingService.execute(Integer.parseInt(id));

        return "redirect:/booking-tickets";
    }


}