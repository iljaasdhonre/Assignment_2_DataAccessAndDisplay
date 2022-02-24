package com.modandmohamed.assignment_2_dataaccessanddisplay.data.track;

import com.modandmohamed.assignment_2_dataaccessanddisplay.data.ConnectionHelper;
import com.modandmohamed.assignment_2_dataaccessanddisplay.model.Track;

import java.sql.*;
import java.util.ArrayList;


public class TrackRepo implements ITrackRepo {

    private final String URL = ConnectionHelper.PRODURL;
    private Connection conn = null;

    @Override
    public ArrayList<Track> getAllTracks() {

        String sqlQuery = "SELECT T.TrackId, T.Name " +
                "FROM Track T " +
                "ORDER BY RANDOM() " +
                "LIMIT 5";

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
                        rs.getString("TrackName")
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
    public ArrayList<Track> getTrackByName(String name) {

        ArrayList<Track> trackList = new ArrayList<>();

        String sqlQuery = "SELECT Artist.Name, Album.Title, Track.TrackId, Track.Name, Genre.Name FROM Track " +
                "INNER JOIN Genre ON Track.GenreId = Genre.GenreId " +
                "INNER JOIN Album ON Album.AlbumId = Track.AlbumId " +
                "INNER JOIN Artist ON Album.ArtistId = Artist.ArtistId " +
                "WHERE Track.Name LIKE ?";


        try {
            //Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection established");

            //Make query
            PreparedStatement statement = conn.prepareStatement(
                    sqlQuery);

            statement.setString(1, "%" + name + "%");

            //Execute query
            ResultSet rs = statement.executeQuery();

            //Process result
            while (rs.next()) {
                trackList.add(
                        new Track(
                                rs.getInt(3),
                                rs.getString(4),
                                rs.getString(1),
                                rs.getString(2),
                                rs.getString(5)
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

        return trackList;
    }
}
