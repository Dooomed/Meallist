package com.prokhorenko.meallist.controllers;

import com.prokhorenko.meallist.dao.service.MealService;
import com.prokhorenko.meallist.model.Meal;
import com.prokhorenko.meallist.model.MealType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/meal")
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping("/all")
    public String allMeals(Model model){

        String message = "There is no meals!";
        List<Meal> mealList = mealService.findAll();
        model.addAttribute("meals", mealList);
        return "allMeals";
    }

    @PostMapping("/create")
    public String create(@RequestParam String name, @RequestParam int weight,
                         @RequestParam BigDecimal price, @RequestParam MealType mealType) {
        Meal meal = new Meal(name, weight, price, mealType);
        mealService.save(meal);
        return "redirect:/meal/all";
    }

    @GetMapping("/create")
    public String createMeal(){
        return "createMeal";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, @RequestParam String name,
                       @RequestParam int weight, @RequestParam BigDecimal price){
        Meal meal = mealService.getById(id);
        meal.setWeight(weight);
        meal.setPrice(price);
        meal.setName(name);
        mealService.update(meal);
        return "redirect:/meal/all";
    }

    @GetMapping("/{id}/edit")
    public String editMeal(Model model, @PathVariable("id") int id){
        model.addAttribute("meal", mealService.getById(id));
        return "editMeal";
    }

    @PostMapping("/{id}")
    public String deleteMeal(@PathVariable(value = "id") int id){
        Meal meal = mealService.getById(id);
        mealService.delete(meal);
        return "redirect:/meal/all";
    }

    @GetMapping("/{id}")
    public String getMeal(Model model, @PathVariable("id") int id){
        model.addAttribute("meal", mealService.getById(id));
        return "meal";
    }
}
