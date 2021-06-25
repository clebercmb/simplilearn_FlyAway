package com.example.simplilearn.flyaway.modules.user.domain;


import com.example.simplilearn.flyaway.modules.user.adapter.in.command.UserCommand;
import com.example.simplilearn.flyaway.modules.user.dto.UserDto;

import javax.persistence.*;


@Entity
@Table(name="place")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="place_id")
    private int placeId;

    @Column(name="name", nullable = false, length = 30)
    private String name;


    public User() {
    }

    public User(UserDto userDto) {
        this.placeId = userDto.getPlaceId();
        this.name = userDto.getName();
    }

    public User(UserCommand userCommand) {
        this.placeId = userCommand.getPlaceId();
        this.name = userCommand.getName();

    }

    public User(int placeId, String name) {
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


    public UserDto getPlaceDto() {
        UserDto userDto = new UserDto();
        userDto.setPlaceId(this.getPlaceId());
        userDto.setName(this.getName());

        return userDto;
    }

    public UserCommand getPlaceCommand() {
        UserCommand userCommand = new UserCommand();
        userCommand.setPlaceId(this.getPlaceId());
        userCommand.setName(this.getName());


        return userCommand;
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeId=" + placeId +
                ", name='" + name + '\'' +
                '}';
    }
}
