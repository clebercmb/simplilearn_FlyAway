package com.example.simplilearn.flyaway.modules.booking.adapter.in.controller;

import com.example.simplilearn.flyaway.modules.booking.adapter.in.command.BookingCommand;
import com.example.simplilearn.flyaway.modules.booking.dto.BookingDto;
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
    public String showBooking(@ModelAttribute("bookingCommand") BookingCommand booking, Model map, @RequestParam String id, @RequestParam String passengers, HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        UserCommand user= (UserCommand) session.getAttribute("user");
        if(user == null) {
            return "login";
        }

        FlightCommand flightCommand = readFlightService.execute(Integer.parseInt(id));
        map.addAttribute("flight", flightCommand);
        map.addAttribute("numberOfPassengers", Integer.parseInt(passengers));
        return "booking";
    }

    @RequestMapping(value = "create-booking", method = RequestMethod.GET)
//    public String post(@ModelAttribute("bookingCommand") BookingCommand booking, Model map, HttpServletRequest request) {
    public String post(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        UserCommand user= (UserCommand) session.getAttribute("user");
        BookingCommand booking= (BookingCommand) session.getAttribute("booking");

        booking.setUserDto(new UserDto(user));

        BookingDto bookingDto = createBookingService.execute(booking);

        session.setAttribute("booking", null);

        return "redirect:/booking-tickets";
    }


    @RequestMapping(value = "payment-booking", method = RequestMethod.POST)
    public String payment(@ModelAttribute("bookingCommand") BookingCommand booking, Model map, HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        FlightCommand flight = readFlightService.execute(booking.getFlightId());

        map.addAttribute("flight", flight);
        map.addAttribute( "passengers", booking.getPassengersList());

        booking.setFlightCommand(flight);
        booking.setPassengersList(booking.getPassengersList());

        session.setAttribute("booking", booking);

        return "bookingPayment";
    }



    @RequestMapping("booking-tickets")
    public String showBookingTickets(Model map, HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        UserCommand user= (UserCommand) session.getAttribute("user");

        List<BookingCommand> bookingCommandList = readBookingByUserIdService.execute(user.getUserId());

        map.addAttribute("bookingList", bookingCommandList);

        return "bookingTickets";
    }

    @RequestMapping("deleteBooking")  // default GET
    public String delete(@RequestParam String id) {

        deleteBookingService.execute(Integer.parseInt(id));

        return "redirect:/booking-tickets";
    }

    @RequestMapping("cancelBooking")  // default GET
    public String delete(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        session.setAttribute("booking", null);

        return "redirect:/booking-tickets";
    }



}
