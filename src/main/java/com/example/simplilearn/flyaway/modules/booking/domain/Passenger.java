package com.example.simplilearn.flyaway.modules.booking.domain;

import com.example.simplilearn.flyaway.modules.booking.dto.PassengerDto;

import javax.persistence.*;

@Entity
@Table(name="passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="passenger_id")
    private int passengerId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    public Passenger() {
    }

    public Passenger(PassengerDto passengerDto) {
        this.passengerId = passengerDto.getPassengerId();
        this.firstName = passengerDto.getFirstName();
        this.email = passengerDto.getEmail();
        this.lastName = passengerDto.getLastName();
    }

    public Passenger(int passengerId, String firstName, String email, String lasName) {
        this.passengerId = passengerId;
        this.firstName = firstName;
        this.email = email;
        this.lastName = lasName;
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

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PassengerDto getPassengerDto() {
        PassengerDto passengerDto = new PassengerDto();
        passengerDto.setPassengerId(this.passengerId);
        passengerDto.setFirstName(this.firstName);
        passengerDto.setEmail(this.email);
        passengerDto.setFirstName(this.lastName);

        return passengerDto;
    }
}
