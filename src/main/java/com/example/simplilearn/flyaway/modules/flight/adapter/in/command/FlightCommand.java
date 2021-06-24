package com.example.simplilearn.flyaway.modules.flight.adapter.in.command;

import com.example.simplilearn.flyaway.modules.places.adapter.in.command.PlaceCommand;
import com.example.simplilearn.flyaway.modules.places.domain.Place;

import java.util.List;

public class FlightCommand {


    private int flightId;
    private String flightNumber;

    private String from;
    private String to;

    private String departureTime;

    private String arriveTime;
    private int seatsCapacity;
    private float ticketPrice;

    private int placeIdFrom;
    private int placeIdTo;

    private Place fromPlace;
    private Place toPlace;

    List<PlaceCommand> placeFromList;
    List<PlaceCommand> placeToList;



    public FlightCommand() {
    }

    public FlightCommand(int flightId,
                         String flightNumber,
                         String from,
                         String to,
                         String departureTime,
                         String arriveTime,
                         int seatsCapacity,
                         float ticketPrice,
                         int placeIdFrom,
                         int placeIdTo,
                         List<PlaceCommand> placeFromList) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arriveTime = arriveTime;
        this.seatsCapacity = seatsCapacity;
        this.ticketPrice = ticketPrice;
        this.placeIdFrom = placeIdFrom;
        this.placeIdTo = placeIdTo;
        this.placeFromList = placeFromList;
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

    public int getPlaceIdFrom() {
        return placeIdFrom;
    }

    public void setPlaceIdFrom(int placeIdFrom) {
        this.placeIdFrom = placeIdFrom;
    }

    public int getPlaceIdTo() {
        return placeIdTo;
    }

    public void setPlaceIdTo(int placeIdTo) {
        this.placeIdTo = placeIdTo;
    }

    public List<PlaceCommand> getPlaceFromList() {
        return placeFromList;
    }

    public void setPlaceFromList(List<PlaceCommand> placeFromList) {
        this.placeFromList = placeFromList;
    }

    public Place getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(Place fromPlace) {
        this.fromPlace = fromPlace;
    }

    public List<PlaceCommand> getPlaceToList() {
        return placeToList;
    }

    public void setPlaceToList(List<PlaceCommand> placeToList) {
        this.placeToList = placeToList;
    }

    public Place getToPlace() {
        return toPlace;
    }

    public void setToPlace(Place toPlace) {
        this.toPlace = toPlace;
    }
}
