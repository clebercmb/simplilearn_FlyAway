package com.example.simplilearn.flyaway.modules.booking.domain;


import com.example.simplilearn.flyaway.modules.booking.adapter.in.command.BookingCommand;
import com.example.simplilearn.flyaway.modules.booking.dto.BookingDto;
import com.example.simplilearn.flyaway.modules.booking.dto.PassengerDto;
import com.example.simplilearn.flyaway.modules.flight.domain.Flight;
import com.example.simplilearn.flyaway.modules.user.domain.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="booking_id")
    private Integer bookingId;


    @OneToOne(targetEntity = Flight.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_flight_id", referencedColumnName = "flight_id")
    private Flight flight;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    private User user;


    @OneToMany(targetEntity = Passenger.class, cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Passenger> passengers=new HashSet<>();

    public Booking() {
    }

    public Booking(BookingDto bookingDto) {
        this.setBookingId( bookingDto.getBookingId() );
        this.setUser( bookingDto.getUser().getUser() );
        this.setFlight( bookingDto.getFlight().getFlight());
        Set<Passenger> passengers = new HashSet<>();
        bookingDto.getPassengers().forEach(p -> passengers.add(p.getPassenger()));
        this.setPassengers(passengers);
    }

   public   Booking(BookingCommand bookingCommand) {
        this.bookingId = bookingCommand.getBookingId();
        this.user  = bookingCommand.getUserDto().getUser();
        this.flight = bookingCommand.getFlightDto().getFlight();
        Set<Passenger> passengers = new HashSet<>();
        bookingCommand.getPassengersList().forEach(p -> passengers.add(p.getPassenger()));
        this.passengers = passengers;
    }

    public Booking(Integer bookingId, Flight flight, User user, Set<Passenger> passengers) {
        this.bookingId = bookingId;
        this.flight = flight;
        this.user = user;
        this.passengers = passengers;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public void removePassenger(Passenger passenger) {
        this.passengers.remove(passenger);
    }

    public BookingDto getBookingDto() {

        BookingDto bookingDto = new BookingDto();

        bookingDto.setBookingId(this.bookingId);
        bookingDto.setFlight(this.flight.getFlightDto());
        bookingDto.setUser(this.user.getUserDto());

        List<PassengerDto> passengers = new ArrayList<>();
        if(this.passengers != null) {
            this.passengers.stream().sorted((p1,p2) -> p1.getFirstName().compareTo(p2.getFirstName())).forEach(p->passengers.add(p.getPassengerDto()));
        }

        bookingDto.setPassengers(passengers);

        return bookingDto;
    }

    public BookingCommand getBookingCommand() {

        BookingCommand bookingCommand = new BookingCommand();

        bookingCommand.setBookingId(this.bookingId);
        bookingCommand.setFlightDto(this.flight.getFlightDto());
        bookingCommand.setUserDto(this.user.getUserDto());

        List<PassengerDto> passengers = new ArrayList<>();
        if(this.passengers != null) {
            this.passengers.stream().sorted((p1,p2) -> p1.getFirstName().compareTo(p2.getFirstName())).forEach(p->passengers.add(p.getPassengerDto()));
        }

        bookingCommand.setPassengersList(passengers);

        return bookingCommand;
    }



}
