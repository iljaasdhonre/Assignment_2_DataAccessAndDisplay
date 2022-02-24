package com.modandmohamed.assignment_2_dataaccessanddisplay.view;

import com.modandmohamed.assignment_2_dataaccessanddisplay.data.track.TrackRepo;
import com.modandmohamed.assignment_2_dataaccessanddisplay.model.Track;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class TrackDetailsController {

    TrackRepo tRepo = new TrackRepo();

    @GetMapping("/trackSearch")
    public String trackDetails(@RequestParam String query, Model model) {
        if(query != null && !query.equals("")){
            ArrayList<Track> trackList = tRepo.getTrackByName(query);
            model.addAttribute("trackList", trackList);
            return "trackDetails";
        }
        else{
            return  "redirect:/";
        }
    }
}
