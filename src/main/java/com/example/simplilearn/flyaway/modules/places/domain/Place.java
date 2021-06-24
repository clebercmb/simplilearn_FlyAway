package com.example.simplilearn.flyaway.modules.places.domain;


import com.example.simplilearn.flyaway.modules.places.adapter.in.command.PlaceCommand;
import com.example.simplilearn.flyaway.modules.places.dto.PlaceDto;

import javax.persistence.*;


@Entity
@Table(name="place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="place_id")
    private int placeId;

    @Column(name="name", nullable = false, length = 30)
    private String name;


    public Place() {
    }

    public Place(PlaceDto placeDto) {
        this.placeId = placeDto.getPlaceId();
        this.name = placeDto.getName();
    }

    public Place(PlaceCommand placeCommand) {
        this.placeId = placeCommand.getPlaceId();
        this.name = placeCommand.getName();

    }

    public Place(int placeId, String name) {
        this.placeId = placeId;
        this.name = name;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int flightId) {
        this.placeId = flightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String flightNumber) {
        this.name = flightNumber;
    }


    public PlaceDto getPlaceDto() {
        PlaceDto placeDto = new PlaceDto();
        placeDto.setPlaceId(this.getPlaceId());
        placeDto.setName(this.getName());

        return placeDto;
    }

    public PlaceCommand getPlaceCommand() {
        PlaceCommand placeCommand = new PlaceCommand();
        placeCommand.setPlaceId(this.getPlaceId());
        placeCommand.setName(this.getName());


        return placeCommand;
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeId=" + placeId +
                ", name='" + name + '\'' +
                '}';
    }
}
