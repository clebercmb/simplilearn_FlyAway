package com.example.simplilearn.flyaway.modules.places.adapter.in.controller;

import com.example.simplilearn.flyaway.modules.places.adapter.in.command.PlaceCommand;
import com.example.simplilearn.flyaway.modules.places.dto.PlaceDto;
import com.example.simplilearn.flyaway.modules.places.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PlaceController {

    CreatePlaceService createPlaceService;
    ReadAllPlacesService readAllPlacesService;
    DeletePlaceService deletePlaceService;
    ReadPlaceService readPlaceService;
    UpdatePlaceService updatePlaceService;

    public PlaceController(CreatePlaceService createPlaceService,
                           ReadAllPlacesService readAllPlacesService,
                           DeletePlaceService deletePlaceService,
                           ReadPlaceService readPlaceService,
                           UpdatePlaceService updatePlaceService) {
        this.createPlaceService = createPlaceService;
        this.readAllPlacesService = readAllPlacesService;
        this.deletePlaceService = deletePlaceService;
        this.readPlaceService = readPlaceService;
        this.updatePlaceService = updatePlaceService;
    }

    @RequestMapping("place")
    public String show(@ModelAttribute("placeCommand") PlaceCommand place) {
        return "place";
    }


    @RequestMapping("updatePlace")
    public String showUpdatePlace(@ModelAttribute("placeCommand") PlaceCommand place, @RequestParam String id, Model map) {
        place = readPlaceService.execute(Integer.parseInt(id));
        map.addAttribute("place", place);

        return "placeUpdate";
    }


    @RequestMapping(value = "createPlace", method = RequestMethod.POST)
    public String post(@ModelAttribute("placeCommand") PlaceCommand place, Model map) {
        PlaceDto placeDto = createPlaceService.execute(place);
        map.addAttribute("place", placeDto);

        return "redirect:/place-dashboard";
    }


    @RequestMapping(value = "savePlace", method = RequestMethod.POST)
    public String put(@ModelAttribute("placeCommand") PlaceCommand place, Model map) {
        PlaceDto placeDto = updatePlaceService.execute(place);

        map.addAttribute("place", placeDto);

        return "redirect:/place-dashboard";
    }


    @RequestMapping("place-dashboard")
    public String showDashBoard(Model model) {
        System.out.println("showplaceDashBoard");
        List<PlaceCommand> placeList = readAllPlacesService.execute();
        model.addAttribute("places", placeList);

        return "placeDashboard";
    }


    @RequestMapping("deletePlace")  // default GET
    public String delete(@RequestParam String id) {

        deletePlaceService.execute(Integer.parseInt(id));

        return "redirect:/place-dashboard";
    }


}
