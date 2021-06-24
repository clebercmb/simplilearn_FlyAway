package com.example.simplilearn.flyaway.modules.flight.domain;


import com.example.simplilearn.flyaway.modules.flight.adapter.in.command.FlightCommand;
import com.example.simplilearn.flyaway.modules.flight.dto.FlightDto;
import com.example.simplilearn.flyaway.modules.places.domain.Place;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


@Entity
@Table(name="flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="flight_id")
    private int flightId;

    @Column(name="flight_number", nullable = false, length = 30)
    private String flightNumber;

    //@Column(name="from_city", nullable = false, length = 30)
    //private String from;

    @OneToOne(targetEntity = Place.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "place_id_from", referencedColumnName = "place_id")
    private Place from;

    @OneToOne(targetEntity = Place.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "place_id_to", referencedColumnName = "place_id")
    private Place to;

    //@Column(name="to_city", nullable = false, length = 30)
    //private String to;

    @Column(name="departure_time", nullable = false)
    private LocalDateTime departureTime;


    @Column(name="arrive_time", nullable = false)
    private LocalDateTime arriveTime;

    @Column(name="seats_capacity", nullable = false)
    private int seatsCapacity;

    @Column(name="ticket_price", nullable = false)
    private float ticketPrice;


    public Flight() {
    }

    public Flight(FlightDto flightDto) {
        this.flightNumber = flightDto.getFlightNumber();
        this.from = new Place(flightDto.getFrom());
        this.to = new Place(flightDto.getTo());
        this.departureTime = flightDto.getDepartureTime();
        this.arriveTime = flightDto.getArriveTime();
        this.seatsCapacity = flightDto.getSeatsCapacity();
        this.ticketPrice = flightDto.getTicketPrice();
    }

    public Flight(FlightCommand flightCommand) {

        this.flightId = flightCommand.getFlightId();
        this.flightNumber = flightCommand.getFlightNumber();
        this.from = new Place(flightCommand.getPlaceIdFrom(), flightCommand.getFrom());
        this.to = new Place(flightCommand.getPlaceIdTo(), flightCommand.getTo());
        this.departureTime = LocalDateTime.parse(flightCommand.getDepartureTime());
        this.arriveTime = LocalDateTime.parse(flightCommand.getArriveTime());
        this.seatsCapacity = flightCommand.getSeatsCapacity();
        this.ticketPrice = flightCommand.getTicketPrice();
    }


    public Flight(int flightId, String flightNumber, Place from, Place to, LocalDateTime departureTime, LocalDateTime arriveTime, int seatsCapacity, float ticketPrice) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arriveTime = arriveTime;
        this.seatsCapacity = seatsCapacity;
        this.ticketPrice = ticketPrice;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Place getFrom() {
        return from;
    }

    public void setFrom(Place from) {
        this.from = from;
    }

    public Place getTo() {
        return to;
    }

    public void setTo(Place to) {
        this.to = to;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(LocalDateTime arriveTime) {
        this.arriveTime = arriveTime;
    }

    public int getSeatsCapacity() {
        return seatsCapacity;
    }

    public void setSeatsCapacity(int seatsCapacity) {
        this.seatsCapacity = seatsCapacity;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public FlightDto getFlightDto() {
        FlightDto flightDto = new FlightDto();
        flightDto.setFlightId(this.getFlightId());
        flightDto.setFlightNumber(this.getFlightNumber());
        flightDto.setFrom(this.getFrom().getPlaceDto());
        flightDto.setTo(this.getTo().getPlaceDto());
        flightDto.setArriveTime(this.getArriveTime());
        flightDto.setDepartureTime(this.getDepartureTime());
        flightDto.setSeatsCapacity(this.getSeatsCapacity());
        flightDto.setTicketPrice(this.getTicketPrice());

        return flightDto;
    }

    public FlightCommand getFlightCommand() {
        FlightCommand flightCommand = new FlightCommand();
        //2021-06-24T17:14
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");


        flightCommand.setFlightId(this.getFlightId());
        flightCommand.setFlightNumber(this.getFlightNumber());
        flightCommand.setFrom(this.getFrom().getName());
        flightCommand.setTo(this.getTo().getName());
        flightCommand.setPlaceIdFrom(this.getFrom().getPlaceId());
        flightCommand.setPlaceIdTo(this.getTo().getPlaceId());
//        flightCommand.setArriveTime(this.getArriveTime().toString());
//        flightCommand.setDepartureTime(this.getDepartureTime().toString());
        flightCommand.setArriveTime(this.getArriveTime().format(formatter));
        flightCommand.setDepartureTime(this.getDepartureTime().format(formatter));
        flightCommand.setSeatsCapacity(this.getSeatsCapacity());
        flightCommand.setTicketPrice(this.getTicketPrice());

        return flightCommand;
    }


    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", flightNumber='" + flightNumber + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", departureTime=" + departureTime +
                ", arriveTime=" + arriveTime +
                ", seatsCapacity=" + seatsCapacity +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
