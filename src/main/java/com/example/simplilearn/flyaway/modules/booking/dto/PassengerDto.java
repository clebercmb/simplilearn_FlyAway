package com.example.simplilearn.flyaway.modules.booking.dto;

import com.example.simplilearn.flyaway.modules.booking.domain.Passenger;

public class PassengerDto {

    private int passengerId;
    private String firstName;
    private String lastName;
    private String email;

    public PassengerDto() {
    }

    public PassengerDto(int passengerId, String firstName, String email, String lastName) {
        this.passengerId = passengerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Passenger getPassenger() {
        Passenger passenger = new Passenger();
        passenger.setPassengerId(this.passengerId);
        passenger.setFirstName(this.firstName);

        passenger.setEmail(this.email);

        return passenger;
    }
}
