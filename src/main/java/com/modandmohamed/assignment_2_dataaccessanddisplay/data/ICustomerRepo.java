package com.modandmohamed.assignment_2_dataaccessanddisplay.data;

import com.modandmohamed.assignment_2_dataaccessanddisplay.model.Customer;
import com.modandmohamed.assignment_2_dataaccessanddisplay.model.CustomerCountry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ICustomerRepo {
    ArrayList<Customer> getAllCustomers();
    Customer getCustomerById(String customerId);
    Customer getCustomerByName(String firstName, String lastName);
    ArrayList<Customer> getCustomerByLimitAndOffset(String limit, String offset);
    ArrayList<CustomerCountry> getCustomersInCountry();
    ArrayList<Customer> getCustomerSpending();
    boolean addCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    ArrayList<Customer> getMostPopularGenreCustomer(String customerId);
}
