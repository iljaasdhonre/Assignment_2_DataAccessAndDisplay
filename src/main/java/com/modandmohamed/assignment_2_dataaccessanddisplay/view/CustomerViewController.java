package com.modandmohamed.assignment_2_dataaccessanddisplay.view;

import com.modandmohamed.assignment_2_dataaccessanddisplay.data.CustomerRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerViewController {

    /*
     * "GET /"
     * "GET /customers/all"
     */

    CustomerRepo crepo = new CustomerRepo();

//    @GetMapping("/")
//    public String home(){
//        return "index";
//    }
//
    @GetMapping("/allcustomers/")
    public String getAllCustomers(Model model){
        model.addAttribute("customers", crepo.getAllCustomers());
        return "view-customers";
    }
}
