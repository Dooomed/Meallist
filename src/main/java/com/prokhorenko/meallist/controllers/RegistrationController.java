package com.prokhorenko.meallist.controllers;

import com.prokhorenko.meallist.dao.service.UserService;
import com.prokhorenko.meallist.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model)
    {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    /*@PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult,
                          Model model) {
        if(bindingResult.hasErrors()){
            return "registration";
        }
        if(userService.save(userForm)){
            model.addAttribute("usernameError", "Пользователь с таки мименем уже существует.");
            return "registration";
        }

        return "redirect:/login";
    }*/
}
