package com.modandmohamed.assignment_2_dataaccessanddisplay.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("track", tRepo.getAllTracks());
        model.addAttribute("artist", aRepo.getAllArtists());
        model.addAttribute("genre", gRepo.getAllGenres());
    }
}
