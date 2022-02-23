package com.modandmohamed.assignment_2_dataaccessanddisplay.data.artist;

import com.modandmohamed.assignment_2_dataaccessanddisplay.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IArtistRepo {
    ArrayList<Artist> getAllArtists();
    Artist getArtistById(String artistId);
    Artist getArtistByName();
}
