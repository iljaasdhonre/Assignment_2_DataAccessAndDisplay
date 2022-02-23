package com.modandmohamed.assignment_2_dataaccessanddisplay.model;

import java.util.List;

public abstract class Customer {

    //fields
    private int customerId;
    private String firstName;
    private String lastName;
    private String postalCode;
    private String phone;
    private String email;
    private String country;

    //constructors
    public Customer() {
    }

    public Customer(int customerId, String firstName, String lastName,
                    String postalCode, String phone, String email, String country) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
        this.phone = phone;
        this.email = email;
        this.country = country;

    }

    //getters and setters
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
