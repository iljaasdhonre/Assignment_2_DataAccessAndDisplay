package com.modandmohamed.assignment_2_dataaccessanddisplay.model;

public class Track {

    //fields
    private int trackId;
    private String name;

    //constructor
    public Track(int trackId, String name) {
        this.trackId = trackId;
        this.name = name;
    }

    public Track() {

    }

    //getters and setters
    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
