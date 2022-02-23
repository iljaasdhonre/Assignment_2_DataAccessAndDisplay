package com.modandmohamed.assignment_2_dataaccessanddisplay.model;

public class Country {
    //fields
    private String countryName;
    private int totalCustomers;

    //constructor
    public Country(String countryName, int totalCustomers) {
        this.countryName = countryName;
        this.totalCustomers = totalCustomers;
    }

    //getters and setters
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(int totalCustomers) {
        this.totalCustomers = totalCustomers;
    }
}

