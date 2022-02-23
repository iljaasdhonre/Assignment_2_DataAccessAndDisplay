package com.modandmohamed.assignment_2_dataaccessanddisplay.data.track;

import com.modandmohamed.assignment_2_dataaccessanddisplay.model.Track;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ITrackRepo {
    ArrayList<Track> getAllTracks();
    Track getTrackById(String trackId);
    Track getTrackByName(String name);
}
