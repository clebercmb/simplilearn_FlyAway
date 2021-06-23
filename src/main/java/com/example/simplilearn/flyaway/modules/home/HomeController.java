package com.example.simplilearn.flyaway.modules.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value={"", "/", "home"})
    public String showHome() {
        System.out.println("Show Home requested");
        return "index";
    }

    @RequestMapping("login")
    public String showLogin() {
        System.out.println("Show Login requested");
        return "login";
    }

    @RequestMapping("flight-dashboard")
    public String showFlightDashBoard() {
        System.out.println("show flight_dashboard requested");
        return "flightDashboard";
    }

    @RequestMapping("booking")
    public String showBooking() {
        System.out.println("show Booking");
        return "booking";
    }

    @RequestMapping("booking-tickets")
    public String showBookingTickets() {
        System.out.println("showBookingTickets");
        return "bookingTickets";
    }

    @RequestMapping("profile")
    public String showProfile() {
        System.out.println("showProfile");
        return "profile";
    }

    @RequestMapping("flight")
    public String showFlight() {
        System.out.println("showFlight");
        return "flight";
    }

}
