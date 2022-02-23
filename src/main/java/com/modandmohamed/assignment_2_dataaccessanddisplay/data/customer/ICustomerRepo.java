package com.modandmohamed.assignment_2_dataaccessanddisplay.data.customer;

import com.modandmohamed.assignment_2_dataaccessanddisplay.model.Country;
import com.modandmohamed.assignment_2_dataaccessanddisplay.model.Customer;
import com.modandmohamed.assignment_2_dataaccessanddisplay.model.CustomerCountry;
import com.modandmohamed.assignment_2_dataaccessanddisplay.model.CustomerGenre;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ICustomerRepo {
    //Get all customers from customer table
    ArrayList<Customer> getAllCustomers();

    //Get customer from DB with parameter customerId
    Customer getCustomerById(String customerId);

    //Get customer by given firstname and lastname
    Customer getCustomerByName(String firstName, String lastName);

    //Get a set of customers by setting a limit and offset
    ArrayList<Customer> getCustomerByLimitAndOffset(String limit, String offset);

    //Get the total amount of customers per country
    ArrayList<Country> getCustomersInCountry();

    //Get the total amount of spending per customer
    ArrayList<Customer> getCustomerSpending();

    //Add new customer to DB with Customer object in parameter
    boolean addCustomer(CustomerCountry customer);

    //Update existing customer with Customer object in parameter
    boolean updateCustomer(String customerId, CustomerCountry customer);

    //Get the favourite genre of a customer by id as parameter
    ArrayList<CustomerGenre> getMostPopularGenreCustomer(String customerId);
}
