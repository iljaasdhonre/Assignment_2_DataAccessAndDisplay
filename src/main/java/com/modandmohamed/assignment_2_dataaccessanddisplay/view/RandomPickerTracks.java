package com.modandmohamed.assignment_2_dataaccessanddisplay.view;

import java.util.Random;

import com.modandmohamed.assignment_2_dataaccessanddisplay.data.track.TrackRepo;


public class RandomPickerTracks {

    public String[] randomPickerTracks() {
        String[] trackList = TrackRepo.getAllTracks(); // waarom moet deze static zijn?

        Random one = new Random();
        Random two = new Random();
        Random three = new Random();
        Random four = new Random();
        Random five = new Random();

        int track_1 = one.nextInt(trackList.length);
        int track_2 = two.nextInt(trackList.length);
        int track_3 = three.nextInt(trackList.length);
        int track_4 = four.nextInt(trackList.length);
        int track_5 = five.nextInt(trackList.length);

        return new String[]{trackList[track_1], trackList[track_2], trackList[track_3], trackList[track_4], trackList[track_5]};
    }
}