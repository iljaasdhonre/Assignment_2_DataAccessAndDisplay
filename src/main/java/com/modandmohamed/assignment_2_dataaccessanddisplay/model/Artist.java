package com.modandmohamed.assignment_2_dataaccessanddisplay.model;

public class Artist {

    //fields
    private int artistId;
    private String name;

    //constructor
    public Artist(int artistId, String name) {
        this.artistId = artistId;
        this.name = name;
    }

    //getters and setters
    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
