package com.modandmohamed.assignment_2_dataaccessanddisplay.view;


import java.util.List;
import java.util.Random;

import com.modandmohamed.assignment_2_dataaccessanddisplay.data.track.TrackRepo;
import com.modandmohamed.assignment_2_dataaccessanddisplay.model.Track;


public class RandomPickerTracks {

    public List<Track> randomPickerTracks() {
        TrackRepo trackRepo = new TrackRepo();

        List<Track> trackList = trackRepo.getAllTracks();

        Random one = new Random();
        Random two = new Random();
        Random three = new Random();
        Random four = new Random();
        Random five = new Random();

        int track_1 = one.nextInt(trackList.size());
        int track_2 = two.nextInt(trackList.size());
        int track_3 = three.nextInt(trackList.size());
        int track_4 = four.nextInt(trackList.size());
        int track_5 = five.nextInt(trackList.size());

        return List.of(trackList.get(track_1), trackList.get(track_2), trackList.get(track_3),
                trackList.get(track_4), trackList.get(track_5));
    }
}