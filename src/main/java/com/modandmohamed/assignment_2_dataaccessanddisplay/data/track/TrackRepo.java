package com.modandmohamed.assignment_2_dataaccessanddisplay.data.track;

import com.modandmohamed.assignment_2_dataaccessanddisplay.data.ConnectionHelper;
import com.modandmohamed.assignment_2_dataaccessanddisplay.model.Artist;
import com.modandmohamed.assignment_2_dataaccessanddisplay.model.Track;

import java.sql.*;
import java.util.ArrayList;


public class TrackRepo implements ITrackRepo{

    private final String URL = ConnectionHelper.URL;
    private Connection conn = null;

    @Override
    public ArrayList<Track> getAllTracks() {

        String sqlQuery = "SELECT * FROM Track";

        ArrayList<Track> tracks = new ArrayList<>();

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
                tracks.add(
                        new Track(
                                rs.getInt("TrackId"),
                                rs.getString("TrackName"),
                                rs.getString("Composer"),
                                rs.getInt("Milliseconds"),
                                rs.getInt("Bytes"),
                                rs.getDouble("UnitPrice")
                        ));
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

        return tracks;
    }


    @Override
    public Track getTrackById(String trackId) {

        Track track = null;

        String sqlQuery = "SELECT * FROM Track";

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
                track = new Track(
                                rs.getInt("TrackId"),
                                rs.getString("TrackName"),
                                rs.getString("Composer"),
                                rs.getInt("Milliseconds"),
                                rs.getInt("Bytes"),
                                rs.getDouble("UnitPrice")
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
        return track;
    }

    @Override
    public Track getTrackByName(String name) {

        Track track = null;

        String sqlQuery = "SELECT * FROM Track WHERE Name LIKE = ?";

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
                track = new Track(
                        rs.getInt("TrackId"),
                        rs.getString("TrackName"),
                        rs.getString("Composer"),
                        rs.getInt("Milliseconds"),
                        rs.getInt("Bytes"),
                        rs.getDouble("UnitPrice")
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

        return track;
    }
}
