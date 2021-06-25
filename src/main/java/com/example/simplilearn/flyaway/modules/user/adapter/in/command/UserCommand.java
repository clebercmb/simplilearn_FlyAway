package com.example.simplilearn.flyaway.modules.user.adapter.in.command;

public class UserCommand {

    private int placeId;
    private String name;
    private String selected="";

    public UserCommand() {
    }

    public UserCommand(int placeId, String name) {
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

    public String getSelected() {
        return selected;
    }

    public void activeSelected() {
        this.selected = "selected";
    }

    public void deActiveSelected() {
        this.selected = "";
    }


}
