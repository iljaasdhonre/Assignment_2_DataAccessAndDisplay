package com.modandmohamed.assignment_2_dataaccessanddisplay.view;

import com.modandmohamed.assignment_2_dataaccessanddisplay.data.artist.ArtistRepo;
import com.modandmohamed.assignment_2_dataaccessanddisplay.data.genre.GenreRepo;
import com.modandmohamed.assignment_2_dataaccessanddisplay.data.track.TrackRepo;
import com.modandmohamed.assignment_2_dataaccessanddisplay.model.Track;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    TrackRepo tRepo = new TrackRepo();
    ArtistRepo aRepo = new ArtistRepo();
    GenreRepo gRepo = new GenreRepo();

    @GetMapping("/")
    public String home(@RequestParam(name = "trackSearch", required = false)
                               String trackSearch, Model model) {

        model.addAttribute("artists", aRepo.getAllArtists());
        model.addAttribute("genres", gRepo.getAllGenres());
        model.addAttribute("tracks", tRepo.getAllTracks());
        model.addAttribute("trackSearch", tRepo.getTrackByName(trackSearch));

        if (trackSearch != null && !trackSearch.equals("")) {
            model.addAttribute("trackSearch", trackSearch);
            model.addAttribute("track", tRepo.getTrackByName(trackSearch));
        } else {
            success = false;
            model.addAttribute("success", success);
        }
        return "home";
    }

    @PostMapping("/")
    public String trackSearch(@RequestParam("trackSearch") String trackSearch) {
        return "redirect:/result?trackSearch=" + trackSearch;
    }

    @GetMapping("/request")
    public String trackDetails(Model model, @RequestParam String trackSearch) {
        model.addAttribute("trackDetails", tRepo.getTrackByName(trackSearch));
        model.addAttribute("trackSearch", trackSearch);
        return "trackDetails";
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
//
//@PostMapping("/home")
//public String searchTrack (@ModelAttribute String trackName,
//        BindingResult errors, Model model) {
//        boolean succes = tRepo.getTrackByName(trackName);
//
//        if(succes){
//        model.addAttribute()
//        }
//
//
//
//        if (trackSearch != null && !trackSearch.equals("")) {
//        model.addAttribute("trackName", tRepo.getTrackByName(trackSearch));
//        model.addAttribute("trackSearch", trackSearch);
//        } else {
//        model.addAttribute("tracks", tRepo.getAllTracks());
//        }
//        return "trackDetails";
//        }