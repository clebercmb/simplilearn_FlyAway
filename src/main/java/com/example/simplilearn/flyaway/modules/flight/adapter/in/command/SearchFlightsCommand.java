package com.example.simplilearn.flyaway.modules.flight.adapter.in.command;

public class SearchFlightsCommand {

    private int tripType;
    private String from;
    private String to;
    private int numberOfPassengers;
    private String departureTime;
    private String returnTime;

    public SearchFlightsCommand() {
    }

    public SearchFlightsCommand(int tripType, String from, String to, int numberOfPassengers, String departureTime, String returnTime) {
        this.tripType = tripType;
        this.from = from;
        this.to = to;
        this.numberOfPassengers = numberOfPassengers;
        this.departureTime = departureTime;
        this.returnTime = returnTime;
    }

    public int getTripType() {
        return tripType;
    }

    public void setTripType(int tripType) {
        this.tripType = tripType;
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

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }
}
