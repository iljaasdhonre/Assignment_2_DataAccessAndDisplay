package com.modandmohamed.assignment_2_dataaccessanddisplay.dataaccess.model;

import java.sql.*;

import static com.modandmohamed.assignment_2_dataaccessanddisplay.dataaccess.database.ConnectionHelper.URL;

public class Customer { //private properties
    private String firstName;
    private String lastName;
    private String customerID;
    private String country;
    private String postalCode;
    private String phoneNumber;
    private String email;

    public Customer(String firstName, String lastName, String customerID, String country, String postalCode, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerID = customerID;
        this.country = country;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //getter and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
