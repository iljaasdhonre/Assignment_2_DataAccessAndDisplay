package com.modandmohamed.assignment_2_dataaccessanddisplay.model;

import java.util.List;

public class Customer {

    //fields
    private int customerId;
    private String firstName;
    private String lastName;
    private String postalCode;
    private String phone;
    private String email;
    private String country;
    private double totalSpending;
    private List<CustomerGenre> favoriteGenre;

    //constructors
    public Customer(int customerId, String firstName, String lastName,
                    String postalCode, String phone, String email,
                    String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerId = customerId;
        this.country = country;
        this.postalCode = postalCode;
        this.phone = phone;
        this.email = email;
    }

    public Customer(int customerId, String firstName, String lastName,
                    String postalCode, String phone, String email,
                    String country, double totalSpending) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
        this.phone = phone;
        this.email = email;
        this.country = country;
        this.totalSpending = totalSpending;
    }

    public Customer(int customerId, String firstName, String lastName,
                    List<CustomerGenre> favoriteGenre) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteGenre = favoriteGenre;
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

    public double getTotalSpending() {
        return totalSpending;
    }

    public void setTotalSpending(double totalSpending) {

        this.totalSpending = totalSpending;
    }

    public List<CustomerGenre> getFavoriteGenre() {
        return favoriteGenre;
    }

    public void setFavoriteGenre(List<CustomerGenre> favoriteGenre) {
        this.favoriteGenre = favoriteGenre;
    }

    //toString() method
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", totalSpending=" + totalSpending +
                ", favoriteGenre=" + favoriteGenre +
                '}';
    }
}
