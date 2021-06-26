package com.example.simplilearn.flyaway.modules.home;

import com.example.simplilearn.flyaway.modules.flight.adapter.in.command.SearchFlightsCommand;
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


}
