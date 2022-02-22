package com.modandmohamed.assignment_2_dataaccessanddisplay.data;

import com.modandmohamed.assignment_2_dataaccessanddisplay.model.Customer;
import com.modandmohamed.assignment_2_dataaccessanddisplay.model.CustomerCountry;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

@Service
public class CustomerRepo implements ICustomerRepo {

    private final String URL = ConnectionHelper.URL;
    private Connection conn = null;

    public CustomerRepo() {
    }



    //Get all customers from customer table
    @Override
    public ArrayList<Customer> getAllCustomers() {
        String sqlQuery = "SELECT " +
                "C.CustomerId, C.FirstName, C.LastName, C.PostalCode," +
                "C.Phone, C.Email, C.Country " +
                "FROM Customer C";

        ArrayList<Customer> customers = new ArrayList<>();

        try {
            //Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection established");

            //Make query
            PreparedStatement statement = conn.prepareStatement(
                    sqlQuery);

            //Execute query
            ResultSet rs = statement.executeQuery();

            //Process result
            while (rs.next()) {
                customers.add(
                        new Customer(
                                rs.getInt("CustomerId"),
                                rs.getString("FirstName"),
                                rs.getString("LastName"),
                                rs.getString("PostalCode"),
                                rs.getString("Phone"),
                                rs.getString("Email"),
                                rs.getString("Country"))

                );
            }
        } catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        } finally {
            try {
                conn.close();
                System.out.println("Connection closed");
            } catch (SQLException sqe) {
                sqe.printStackTrace();
                System.exit(-1);
            }
        }
        return customers;
    }

    //Get customer from DB with parameter customerId
    @Override
    public Customer getCustomerById(String customerId) {
        Customer customer = null;
        String sqlQuery = "SELECT CustomerId, FirstName, LastName, PostalCode, Phone, Email, Country" +
                " FROM Customer WHERE CustomerId = ?";

        try {
            //Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection established");

            //Make Query
            PreparedStatement statement = conn.prepareStatement(sqlQuery);
            statement.setString(1, customerId);

            //Execute Query
            ResultSet result = statement.executeQuery();

            //Process result
            while (result.next()) {
                customer = new Customer(
                        result.getInt("CustomerId"),
                        result.getString("FirstName"),
                        result.getString("LastName"),
                        result.getString("PostalCode"),
                        result.getString("Phone"),
                        result.getString("Email"),
                        result.getString("Country")
                );
            }
            System.out.println("Get customer by id: " + customerId + " successful");
        } catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        } finally {
            try {
                conn.close();
                System.out.println("Connection closed");
            } catch (SQLException sqe) {
                sqe.printStackTrace();
                System.exit(-1);
            }
        }
        return customer;
    }

    //Add new customer to DB with Customer object in parameter
    @Override
    public boolean addCustomer(Customer customer) {
        boolean success = false;
        String sqlQuery =
                "INSERT " + "INTO Customer(" +
                        "CustomerId, " +
                        "FirstName, " +
                        "LastName, " +
                        "PostalCode, " +
                        "Phone, " +
                        "Email, " +
                        "Country)" +
                        "VALUES(?,?,?,?,?,?,?)";

        try {
            //Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection established");

            //Make query
            PreparedStatement statement = conn.prepareStatement(sqlQuery);
            statement.setInt(1, customer.getCustomerId());
            statement.setString(2, customer.getFirstName());
            statement.setString(3, customer.getLastName());
            statement.setString(4, customer.getPostalCode());
            statement.setString(5, customer.getPhone());
            statement.setString(6, customer.getEmail());
            statement.setString(7, customer.getCountry());

            //Execute query
            int result = statement.executeUpdate();
            success = (result != 0);

        } catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        } finally {
            try {
                conn.close();
                System.out.println("Connection closed");
            } catch (SQLException sqe) {
                sqe.printStackTrace();
                System.exit(-1);
            }
        }
        return success;
    }

    //Update existing customer with Customer object in parameter
    @Override
    public boolean updateCustomer(Customer customer) {
        boolean success = false;

        String sqlQuery =
                "UPDATE Customer " +
                        "SET FirstName = ?, " +
                        "LastName = ?, " +
                        "PostalCode = ?, " +
                        "Phone = ?," +
                        "Email = ?, " +
                        "Country = ? " +
                        "WHERE CustomerId = ?";

        try {
            //Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection established");

            //Make query
            PreparedStatement statement = conn.prepareStatement(sqlQuery);
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getCountry());
            statement.setString(4, customer.getPostalCode());
            statement.setString(5, customer.getPhone());
            statement.setString(6, customer.getEmail());
            statement.setInt(7, customer.getCustomerId());

            //Execute query
            int result = statement.executeUpdate();
            success = (result != 0);

        } catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        } finally {
            try {
                conn.close();
                System.out.println("Connection closed");
            } catch (SQLException sqe) {
                sqe.printStackTrace();
                System.exit(-1);
            }
        }
        return success;
    }

    //Get customer by given firstname and lastname
    @Override
    public Customer getCustomerByName(String firstName, String lastName) {
        Customer customer = null;
        String sqlQuery = "SELECT * " +
                "FROM Customer " +
                "WHERE FirstName LIKE ? AND LastName LIKE ? ";

        try {
            //Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection established");

            //Make query
            PreparedStatement statement = conn.prepareStatement(sqlQuery);
            statement.setString(1, firstName);
            statement.setString(2, lastName);

            //Execute query
            ResultSet rs = statement.executeQuery();

            //Process rs
            while (rs.next()) {
                customer = new Customer(
                        rs.getInt("CustomerId"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("PostalCode"),
                        rs.getString("Phone"),
                        rs.getString("Email"),
                        rs.getString("Country")
                );
            }
        } catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        } finally {
            try {
                conn.close();
                System.out.println("Connection closed");
            } catch (SQLException sqe) {
                sqe.printStackTrace();
                System.exit(-1);
            }
        }
        return customer;
    }

    //Get a set of customers by setting a limit and offset
    @Override
    public ArrayList<Customer> getCustomerByLimitAndOffset(String limit, String offset) {
        String sqlQuery = "SELECT * " +
                "FROM Customer " +
                "LIMIT ? " + "OFFSET ?";

        ArrayList<Customer> customers = new ArrayList<>();

        try {
            //Connect to DB
            conn = DriverManager.getConnection(URL);
            //ConnectionManager.getInstance().getDbConnection();
            System.out.println("Connection established");

            //Make query
            PreparedStatement statement = conn.prepareStatement(sqlQuery);
            statement.setString(1, limit);
            statement.setString(2, offset);

            //Execute query
            ResultSet rs = statement.executeQuery();

            //Process result
            while (rs.next()) {
                customers.add(new Customer(rs.getInt("CustomerId"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("PostalCode"), rs.getString("Phone"), rs.getString("Email"), rs.getString("Country"))

                );
            }
        } catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        } finally {
            try {
                conn.close();
                System.out.println("Connection closed");
            } catch (SQLException sqe) {
                sqe.printStackTrace();
                System.exit(-1);
            }
        }
        return customers;

    }

    //Get the total amount of customers per country
    @Override
    public ArrayList<CustomerCountry> getCustomersInCountry() {
        ArrayList<CustomerCountry> customersInCountry = new ArrayList<>();
        String sqlQuery = "SELECT COUNT(CustomerId), Country " +
                "FROM Customer " +
                "GROUP BY Country " +
                "ORDER BY COUNT(*) DESC";

        try {
            //Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection established");

            //Make query
            PreparedStatement statement = conn.prepareStatement(sqlQuery);

            //Execute Query
            ResultSet rs = statement.executeQuery();

            //Process result
            while (rs.next()) {
                customersInCountry.add(new CustomerCountry(rs.getString(2), rs.getInt(1)));
            }

            //Print list
            customersInCountry.forEach(customerCountry -> System.out.println(customerCountry.getCountryName() + ": " + customerCountry.getTotalCustomers()));

        } catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        } finally {
            try {
                conn.close();
                System.out.println("Connection closed");
            } catch (SQLException sqe) {
                sqe.printStackTrace();
                System.exit(-1);
            }
        }
        return customersInCountry;
    }

    //Get the total amount of spending per customer
    @Override
    public ArrayList<Customer> getCustomerSpending(){
        String sqlQuery = "SELECT  C.*, SUM(I.Total) AS Total " +
                "FROM Customer C " +
                "JOIN Invoice I on C.CustomerId = I.CustomerId " +
                "GROUP BY C.CustomerId " +
                "ORDER BY Total DESC";

        ArrayList<Customer> customers = new ArrayList<>();

        try {
            //Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection established");

            //Make query
            PreparedStatement statement = conn.prepareStatement(sqlQuery);

            //Execute query
            ResultSet rs = statement.executeQuery();

            //Process result
            while (rs.next()) {
                customers.add(
                        new Customer(
                                rs.getInt("CustomerId"),
                                rs.getString("FirstName"),
                                rs.getString("LastName"),
                                rs.getString("PostalCode"),
                                rs.getString("Phone"),
                                rs.getString("Email"),
                                rs.getString("Country"),
                                rs.getDouble("Total")
                        )
                );
            }

            //Print list
            customers.forEach(customer ->
                    System.out.println(customer.getFirstName() + ": " + customer.getTotalSpending()));

        } catch (SQLException sqe){
            System.out.println(sqe.getMessage());
        } finally {
            try {
                conn.close();
                System.out.println("Connection closed");
            } catch (SQLException sqe) {
                sqe.printStackTrace();
                System.exit(-1);
            }
        }
        return customers;
    }

    //Get the total amount of spending per customer
    @Override
    public ArrayList<Customer> getMostPopularGenreCustomer(){
        ArrayList<Customer> customers = new ArrayList<>();

        String sqlQuery = "SELECT  * " +
                "FROM Customer " +
                "JOIN Invoice on Customer.CustomerId = Invoice.CustomerId " +
                "JOIN InvoiceLine on Invoice.InvoiceId = InvoiceLine.invoiceId " +
                "JOIN Track on InvoiceLine.TrackId = Track.TrackId " +
                "JOIN Genre on Track.GenreId = Genre.GenreId "; http://localhost:8080/customers/mostpopulargenre




        try {
            //Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection established");

            //Make query
            PreparedStatement statement = conn.prepareStatement(sqlQuery);

            //Execute query
            ResultSet rs = statement.executeQuery();

            //Process result
            while (rs.next()) {
                customers.add(
                        new Customer(
                                rs.getInt("CustomerId"),
                                rs.getString("FirstName"),
                                rs.getString("LastName"),
                                rs.getString("PostalCode"),
                                rs.getString("Phone"),
                                rs.getString("Email"),
                                rs.getString("Country"),
                                rs.getDouble("Total")
                        )
                );
            }

            //Print list
            customers.forEach(customer ->
                    System.out.println(customer.getFirstName() + ": " + customer.getTotalSpending()));

        } catch (SQLException sqe){
            System.out.println(sqe.getMessage());
        } finally {
            try {
                conn.close();
                System.out.println("Connection closed");
            } catch (SQLException sqe) {
                sqe.printStackTrace();
                System.exit(-1);
            }
        }
        return customers;
    }

}
