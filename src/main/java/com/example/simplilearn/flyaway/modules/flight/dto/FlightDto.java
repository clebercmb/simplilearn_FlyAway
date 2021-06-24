package com.example.simplilearn.flyaway.modules.flight.dto;

import com.example.simplilearn.flyaway.modules.flight.adapter.in.command.FlightCommand;
import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;

public class FlightDto {

    private int flightId;
    private String flightNumber;
    private String from;
    private String to;

    @NotNull
    @DateTimeFormat(pattern = "uuuu-MM-dd HH:mm")
    private LocalDateTime departureTime;

    @NotNull
    @DateTimeFormat(pattern = "uuuu-MM-dd HH:mm")
    private LocalDateTime arriveTime;
    private int seatsCapacity;
    private float ticketPrice;

    public FlightDto() {
    }

    public FlightDto(FlightCommand flightCommand) {


    }


    public FlightDto(int flightId, String flightNumber, String from, String to, LocalDateTime departureTime, LocalDateTime arriveTime, int seatsCapacity, float ticketPrice) {
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


    @Override
    public String toString() {
        return "FlightDto{" +
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
