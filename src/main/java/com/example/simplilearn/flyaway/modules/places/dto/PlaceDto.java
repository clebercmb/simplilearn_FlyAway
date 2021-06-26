package com.example.simplilearn.flyaway.modules.places.dto;

import com.example.simplilearn.flyaway.modules.places.adapter.in.command.PlaceCommand;
import com.example.simplilearn.flyaway.modules.places.domain.Place;
import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class PlaceDto {

    private int placeId;
    private String name;

    public PlaceDto() {
    }

    public PlaceDto(PlaceCommand placeCommand) {

    }

    public PlaceDto(int placeId, String name) {
        this.placeId = placeId;
        this.name = name;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Place getPlace() {
        Place place = new Place();
        place.setPlaceId(this.placeId);
        place.setName(this.name);
        return place;
    }


    @Override
    public String toString() {
        return "FlightDto{" +
                "flightId=" + placeId +
                ", flightNumber='" + name + '\'' +
                '}';
    }
}
