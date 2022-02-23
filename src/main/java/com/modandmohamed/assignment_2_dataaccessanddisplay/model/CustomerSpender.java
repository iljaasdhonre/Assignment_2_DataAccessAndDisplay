package com.modandmohamed.assignment_2_dataaccessanddisplay.model;

public class CustomerSpender extends Customer{

    //fields
    private double totalSpending;

    //constructor
    public CustomerSpender(int customerId, String firstName, String lastName,
                           String postalCode, String phone, String email,
                           String country, double totalSpending) {
        super(customerId, firstName, lastName, postalCode, phone, email, country);
        this.totalSpending = totalSpending;
    }

    //getters and setters
    public double getTotalSpending() {
        return totalSpending;
    }

    public void setTotalSpending(double totalSpending) {
        this.totalSpending = totalSpending;
    }
}
