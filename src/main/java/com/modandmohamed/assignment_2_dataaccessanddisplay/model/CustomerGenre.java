package com.modandmohamed.assignment_2_dataaccessanddisplay.model;

public class CustomerGenre {

    //fields
    private String name;
    private int favoriteScore;

    //constructor
    public CustomerGenre(String name, int favoriteScore) {
        this.name = name;
        this.favoriteScore = favoriteScore;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFavoriteScore() {
        return favoriteScore;
    }

    public void setFavoriteScore(int favoriteScore) {
        this.favoriteScore = favoriteScore;
    }
}
