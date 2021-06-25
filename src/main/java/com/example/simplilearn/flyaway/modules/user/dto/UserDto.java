package com.example.simplilearn.flyaway.modules.user.dto;

import com.example.simplilearn.flyaway.modules.user.adapter.in.command.UserCommand;

public class UserDto {

    private int placeId;
    private String name;

    public UserDto() {
    }

    public UserDto(UserCommand userCommand) {


    }

    public UserDto(int placeId, String name) {
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




    @Override
    public String toString() {
        return "FlightDto{" +
                "flightId=" + placeId +
                ", flightNumber='" + name + '\'' +
                '}';
    }
}
