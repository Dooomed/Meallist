package com.prokhorenko.meallist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {

    @GetMapping({"/homepage", "/"})
    public String showHomepage(Model model){
        return "homepage";
    }
}
