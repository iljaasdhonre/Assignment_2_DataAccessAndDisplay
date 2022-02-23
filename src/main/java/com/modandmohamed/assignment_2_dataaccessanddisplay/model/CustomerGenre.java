package com.modandmohamed.assignment_2_dataaccessanddisplay.model;

import java.util.ArrayList;
import java.util.List;

public class CustomerGenre extends Customer {

    //fields
    private List<Genre> favouriteGenre;

    //constructor
    public CustomerGenre(int customerId, String firstName, String lastName, String postalCode, String phone,
                         String email, String country, List<Genre> favouriteGenre) {
        super(customerId, firstName, lastName, postalCode, phone, email, country);
        this.favouriteGenre = favouriteGenre;
    }

    //getters and setters
    public List<Genre> getFavouriteGenre() {
        return favouriteGenre;
    }

    public void setFavouriteGenre(List<Genre> favouriteGenre) {
        this.favouriteGenre = favouriteGenre;
    }
}


