package com.modandmohamed.assignment_2_dataaccessanddisplay.model;

public class CustomerCountry extends Customer{

    //Constructor
    public CustomerCountry(int customerId, String firstName, String lastName,
                           String postalCode, String phone, String email, String country) {
        super(customerId, firstName, lastName, postalCode, phone, email, country);
    }
}
