package com.modandmohamed.assignment_2_dataaccessanddisplay.controller;

import com.modandmohamed.assignment_2_dataaccessanddisplay.data.customer.ICustomerRepo;
import com.modandmohamed.assignment_2_dataaccessanddisplay.model.Country;
import com.modandmohamed.assignment_2_dataaccessanddisplay.model.Customer;
import com.modandmohamed.assignment_2_dataaccessanddisplay.model.CustomerCountry;
import com.modandmohamed.assignment_2_dataaccessanddisplay.model.CustomerGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {

    //fields
    private final ICustomerRepo customerRepo;

    //constructor
    public CustomerController(
            @Autowired
                    ICustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    /*
    * GET all customers
    * GET customer by id
    * GET customer by name
    * GET amount of customers in country
    * GET a set of customers limited by limit and offset
    * GET the total spending of all customers
    * GET the favourite genre of a given customer by id
    * POST add a new customer
    * PUT update a customers info by id*/

    @GetMapping("api/customers/all")
    public ArrayList<Customer> getAllCustomers() {
        return customerRepo.getAllCustomers();
    }

    @GetMapping("api/customers/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        return customerRepo.getCustomerById(id);
    }

    @GetMapping("api/customers/")
    @ResponseBody
    public Customer getCustomerByName(@RequestParam String firstname, String lastname) {
        return customerRepo.getCustomerByName(firstname, lastname);
    }

    @GetMapping("api/customers/country/total")
    public ArrayList<Country> getCustomerInCountries() {
        return customerRepo.getCustomersInCountry();
    }

    @GetMapping("api/customers/set")
    @ResponseBody
    public ArrayList<Customer> getCustomersByLimitAndOffset(@RequestParam String limit, String offset) {
        return customerRepo.getCustomerByLimitAndOffset(limit, offset);
    }

    @GetMapping("api/customers/spending/total")
    public ArrayList<Customer> getCustomerTotalSpending() {
        return customerRepo.getCustomerSpending();
    }

    @GetMapping("api/customers/{id}/genre/popular")
    public ArrayList<CustomerGenre> getMostPopularGenreCustomer(@PathVariable String id){
        return customerRepo.getMostPopularGenreCustomer(id);
    }

    @PostMapping("api/customers")
    public boolean addNewCustomer(@RequestBody CustomerCountry customer) {
        return customerRepo.addCustomer(customer);
    }

    @PutMapping("api/customers/")
    public boolean updateCustomer(@RequestParam String id,
            @RequestBody CustomerCountry customer) {
        return customerRepo.updateCustomer(id, customer);
    }
}
