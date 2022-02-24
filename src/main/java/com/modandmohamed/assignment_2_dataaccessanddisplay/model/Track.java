package com.modandmohamed.assignment_2_dataaccessanddisplay.model;

public class Track {

    //fields
    private int trackId;
    private String name;
    private String artistName;
    private String genreName;
    private String albumTitle;

    //constructor
    public Track(int trackId, String name, String artistName, String albumTitle, String genreName) {
        this.trackId = trackId;
        this.name = name;
        this.artistName = artistName;
        this.genreName = genreName;
        this.albumTitle = albumTitle;
    }

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

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }
}
