package com.modandmohamed.assignment_2_dataaccessanddisplay.data.artist;

import com.modandmohamed.assignment_2_dataaccessanddisplay.data.ConnectionHelper;
import com.modandmohamed.assignment_2_dataaccessanddisplay.model.Artist;

import java.sql.*;
import java.util.ArrayList;

public class ArtistRepo implements IArtistRepo{

    private final String URL = ConnectionHelper.URL;
    private Connection conn = null;


    @Override
    public ArrayList<Artist> getAllArtists() {

        String sqlQuery = "SELECT * FROM Artist A ";

        ArrayList<Artist> artists = new ArrayList<>();

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
                artists.add(
                        new Artist(
                                rs.getInt("ArtistId"),
                                rs.getString("Name")
                        ));
                System.out.println(rs.getString("Name"));
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
        return artists;
    }


    @Override
    public Artist getArtistById(String artistId) {

        Artist artist = null;

        String sqlQuery = "SELECT * FROM Artist WHERE ArtistId = ?";

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
                artist = new Artist(
                        rs.getInt("ArtistId"),
                        rs.getString("Name")
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

        return artist;
    }


    @Override
    public Artist getArtistByName(String name) {

        Artist artist = null;

        String sqlQuery = "SELECT * FROM Artist WHERE Name LIKE ? ";

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
                artist = new Artist(
                        rs.getInt("ArtistId"),
                        rs.getString("Name")
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

        return artist;
    }
}
