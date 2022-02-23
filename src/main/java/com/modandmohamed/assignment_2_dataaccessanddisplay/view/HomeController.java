package com.modandmohamed.assignment_2_dataaccessanddisplay.view;

import com.modandmohamed.assignment_2_dataaccessanddisplay.data.artist.ArtistRepo;
import com.modandmohamed.assignment_2_dataaccessanddisplay.data.genre.GenreRepo;
import com.modandmohamed.assignment_2_dataaccessanddisplay.data.track.TrackRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    TrackRepo tRepo = new TrackRepo();
    ArtistRepo aRepo = new ArtistRepo();
    GenreRepo gRepo = new GenreRepo();

    @GetMapping("/home")
    public String getHome(Model model){
        model.addAttribute("artists", aRepo.getAllArtists());
        model.addAttribute("genres", gRepo.getAllGenres());
        model.addAttribute("tracks", tRepo.getAllTracks());
        return "home";
    }
}
