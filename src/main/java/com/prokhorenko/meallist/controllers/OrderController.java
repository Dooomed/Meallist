package com.prokhorenko.meallist.controllers;

import com.prokhorenko.meallist.dao.service.MealService;
import com.prokhorenko.meallist.dao.service.OrderService;
import com.prokhorenko.meallist.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private MealService mealService;

    @GetMapping("/all")
    public String showAll(Model model){
        model.addAttribute("orders", orderService.findAll());
        return "allOrders";
    }

    @GetMapping("/create")
    public String createOrder(Model model){
        Order order = new Order();
        model.addAttribute("order", order);
        model.addAttribute("meals", mealService.findAll());
        return "createOrder";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("order") Order order) {
        orderService.save(order);
        return "redirect:/order/all";
    }
}
