package com.example.simplilearn.flyaway.modules.flight.adapter.in.command;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class FlightCommand {


    private int flightId;
    private String flightNumber;
    private String from;
    private String to;

    private String departureTime;

    private String arriveTime;
    private int seatsCapacity;
    private float ticketPrice;

    public FlightCommand() {
    }

    public FlightCommand(int flightId, String flightNumber, String from, String to, String departureTime, String arriveTime, int seatsCapacity, float ticketPrice) {
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
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
}
