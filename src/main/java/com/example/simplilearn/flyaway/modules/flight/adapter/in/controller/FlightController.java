package com.example.simplilearn.flyaway.modules.flight.adapter.in.controller;

import com.example.simplilearn.flyaway.modules.flight.adapter.in.command.FlightCommand;
import com.example.simplilearn.flyaway.modules.flight.dto.FlightDto;
import com.example.simplilearn.flyaway.modules.flight.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class FlightController {

    CreateFlightService createFlightService;
    ReadAllFlightsService readAllFlightsService;
    DeleteFlightsService deleteFlightsService;
    ReadFlightService readFlightService;
    UpdateFlightService updateFlightService;

    public FlightController(CreateFlightService createFlightService,
                            ReadAllFlightsService readAllFlightsService,
                            DeleteFlightsService deleteFlightsService,
                            ReadFlightService readFlightService,
                            UpdateFlightService updateFlightService) {
        this.createFlightService = createFlightService;
        this.readAllFlightsService = readAllFlightsService;
        this.deleteFlightsService = deleteFlightsService;
        this.readFlightService = readFlightService;
        this.updateFlightService = updateFlightService;
    }

    @RequestMapping("flight")
    public String updateFlight(@ModelAttribute("flightCommand") FlightCommand flight) {
        System.out.println("showFlight");
        return "flight";
    }

    @RequestMapping("updateFlight")
    public String showUpdateFlight(@ModelAttribute("flightCommand") FlightCommand flight, @RequestParam String id, Model map) {
        flight = readFlightService.execute(Integer.parseInt(id));
        map.addAttribute("flight", flight);

        return "flightUpdate";
    }


    @RequestMapping(value = "createFlight", method = RequestMethod.POST)
    public String post(@ModelAttribute("flightCommand") FlightCommand flight, Model map) {
        FlightDto flightDo = createFlightService.execute(flight);
        map.addAttribute("flight", flightDo);

        return "redirect:/flight-dashboard";
    }


    @RequestMapping(value = "saveFlight", method = RequestMethod.POST)
    public String put(@ModelAttribute("flightCommand") FlightCommand flight, Model map) {
        FlightDto flightDto = updateFlightService.execute(flight);

        map.addAttribute("flight", flightDto);

        return "redirect:/flight-dashboard";
    }

    @RequestMapping("flight-dashboard")
    public String showFlightDashBoard(Model model) {
        System.out.println("showFlightDashBoard");
        ArrayList<FlightCommand> flightsList = readAllFlightsService.execute();
        model.addAttribute("flights", flightsList);

        return "flightDashboard";
    }


    @RequestMapping("deleteFlight")  // default GET
    public String delete(@RequestParam String id) {
        System.out.println("FlightController.delete");
        System.out.println("%%%% id=" + id);

        deleteFlightsService.execute(Integer.parseInt(id));

        return "redirect:/flight-dashboard";
    }


}
