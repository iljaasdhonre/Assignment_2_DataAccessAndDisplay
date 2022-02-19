package com.modandmohamed.assignment_2_dataaccessanddisplay.dataaccess.repository;

import com.modandmohamed.assignment_2_dataaccessanddisplay.dataaccess.database.ConnectionManager;

import java.sql.*;

public class CustomerRepo {

    Connection conn = ConnectionManager.getInstance().getDbConnection();

    private void queryColumnsCustomer(String sql) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("CustomerId") + "\t" +
                        rs.getString("FirstName") + "\t" +
                        rs.getString("LastName") + "\t" +
                        rs.getString("Country") + "\t" +
                        rs.getString("PostalCode") + "\t" +
                        rs.getString("Phone") + "\t" +
                        rs.getString("Email"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException sqe) {
                sqe.printStackTrace();
                System.exit(-1);
            }
        }
    }

    public void ReadAllCustomers() {
        String sql = "SELECT * FROM Customer";
        queryColumnsCustomer(sql);
    }

    public void specificCustomerThroughID(Integer InputID) { // easier when inserting ID
        String sql = "SELECT * FROM Customer WHERE CustomerId =" + InputID.toString();
        queryColumnsCustomer(sql);
    }

    public void searchCustomerThroughName(String Name) {
        String sql = "SELECT * FROM Customer WHERE FirstName LIKE '" + Name + "'";
//        String sql = String.format("SELECT * FROM Customer WHERE FirstName = '%S'", Name); // doesnt work
        queryColumnsCustomer(sql);
    }
}