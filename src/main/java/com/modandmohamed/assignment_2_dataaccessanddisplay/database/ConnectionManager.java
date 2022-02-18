package com.modandmohamed.assignment_2_dataaccessanddisplay.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static ConnectionManager instance;
    private static final String dbUrl = ConnectionHelper.URL;
    private Connection dbConnection;

    //Instantiate singleton of database
    public static ConnectionManager getInstance(){
        if(instance == null){
            instance = new ConnectionManager();
        }
        return instance;
    }

    //constructor
    private ConnectionManager(){
        try{
            dbConnection = DriverManager.getConnection(dbUrl);
        }
        catch(SQLException sqe){
            sqe.printStackTrace();
            System.exit(-1);
        }
    }

    //setup connection with database
    public Connection getDbConnection(){
        return dbConnection;
    }

}
