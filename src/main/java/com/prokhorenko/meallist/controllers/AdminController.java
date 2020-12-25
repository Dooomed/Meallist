package com.prokhorenko.meallist.controllers;

import com.prokhorenko.meallist.dao.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    private UserService userService;

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.findAll());
        return "admin";
    }

    @PostMapping("/admin")
    public String deleteUser(@RequestParam(required = true,defaultValue = "")int id,
                             @RequestParam(required = true,defaultValue = "") String action,
                             Model model) {
        if(action.equals("delete")){
            userService.delete(userService.findById(id));
        }
        return "redirect:/admin";
    }

}
