package com.modandmohamed.assignment_2_dataaccessanddisplay.model;

public class Artist {

    //fields
    private int artistId;
    private String artistName;

    //constructor
    public Artist(int artistId, String artistName) {
        this.artistId = artistId;
        this.artistName = artistName;
    }
    //getters and setters

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
