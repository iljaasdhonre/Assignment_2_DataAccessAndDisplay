package com.modandmohamed.assignment_2_dataaccessanddisplay.view;

import com.modandmohamed.assignment_2_dataaccessanddisplay.data.artist.ArtistRepo;
import com.modandmohamed.assignment_2_dataaccessanddisplay.data.genre.GenreRepo;
import com.modandmohamed.assignment_2_dataaccessanddisplay.data.track.TrackRepo;
import com.modandmohamed.assignment_2_dataaccessanddisplay.model.Track;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    TrackRepo tRepo = new TrackRepo();
    ArtistRepo aRepo = new ArtistRepo();
    GenreRepo gRepo = new GenreRepo();

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("artists", aRepo.getAllArtists());
        model.addAttribute("genres", gRepo.getAllGenres());
        model.addAttribute("tracks", tRepo.getAllTracks());
        return "home";
    }
}


//    boolean success = crep.addCustomer(customer);
//  if(success){
//          model.addAttribute("customer", new Customer());
//          } else {
//          model.addAttribute("customer", customer);
//          }
//          model.addAttribute("success", success);
//          return "add-customers";

