package com.modandmohamed.assignment_2_dataaccessanddisplay.dataaccess.model;

public class CustomerGenre {
    private Integer GenreId;
    private String Name;

    public CustomerGenre(Integer genreId, String name) {
        GenreId = genreId;
        Name = name;
    }

    public Integer getGenreId() {
        return GenreId;
    }

    public void setGenreId(Integer genreId) {
        GenreId = genreId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
