package com.modandmohamed.assignment_2_dataaccessanddisplay.controller;

import com.modandmohamed.assignment_2_dataaccessanddisplay.data.ICustomerRepo;
import com.modandmohamed.assignment_2_dataaccessanddisplay.model.Customer;
import com.modandmohamed.assignment_2_dataaccessanddisplay.model.CustomerCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {

    private final ICustomerRepo customerRepo;

    public CustomerController(
            @Autowired
                    ICustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @GetMapping("/")
    public String index() {
        return "Root page";
    }

    @GetMapping("/customers/all")
    public ArrayList<Customer> getAllCustomers() {
        return customerRepo.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        return customerRepo.getCustomerById(id);
    }

    @GetMapping("/customers/")
    @ResponseBody
    public Customer getCustomerByName(@RequestParam String firstname, String lastname) {
        return customerRepo.getCustomerByName(firstname, lastname);
    }

    @GetMapping("/customers/country/total")
    public ArrayList<CustomerCountry> getCustomerInCountries() {
        return customerRepo.getCustomersInCountry();
    }

    @GetMapping("customers/set")
    @ResponseBody
    public ArrayList<Customer> getCustomersByLimitAndOffset(@RequestParam String limit, String offset) {
        return customerRepo.getCustomerByLimitAndOffset(limit, offset);
    }

    @GetMapping("customers/spending/total")
    public ArrayList<Customer> getCustomerTotalSpending() {
        return customerRepo.getCustomerSpending();
    }

    @GetMapping("customers/{id}/genre/popular")
    public ArrayList<Customer> getMostPopularGenreCustomer(@PathVariable String id){
        return customerRepo.getMostPopularGenreCustomer(id);
    }

    @PostMapping("/customers")
    public boolean addNewCustomer(@RequestBody Customer customer) {
        return customerRepo.addCustomer(customer);
    }

    @PutMapping("/customers")
    public boolean updateCustomer(@RequestBody Customer customer) {
        return customerRepo.updateCustomer(customer);
    }
}
