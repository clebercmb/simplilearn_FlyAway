package com.example.simplilearn.flyaway.modules.home;

import com.example.simplilearn.flyaway.modules.flight.dto.FlightDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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



}
