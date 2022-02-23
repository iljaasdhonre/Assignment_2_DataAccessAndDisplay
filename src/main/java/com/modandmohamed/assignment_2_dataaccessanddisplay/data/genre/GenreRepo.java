package com.modandmohamed.assignment_2_dataaccessanddisplay.data.genre;

import com.modandmohamed.assignment_2_dataaccessanddisplay.data.ConnectionHelper;
import com.modandmohamed.assignment_2_dataaccessanddisplay.model.Genre;

import java.sql.*;
import java.util.ArrayList;

public class GenreRepo implements IGenreRepo {

    private Connection conn = null;
    private final String URL = ConnectionHelper.URL;

    @Override
    public ArrayList<Genre> getAllGenres() {
        ArrayList<Genre> genres = new ArrayList<>();
        String sqlQuery = "SELECT G.Name FROM Genre G ";

        try {
            //connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection established");

            //make query
            PreparedStatement statement = conn.prepareStatement(sqlQuery);

            //process result
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                genres.add(
                        new Genre(
                                rs.getString("Name")
                        )
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
        return genres;
    }
}
