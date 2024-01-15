package com.mystartup.food.controller;

import com.mystartup.food.model.Food;
import com.mystartup.food.service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FoodController {
    private FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }
    @PostMapping("/home")
    public String addFood(Model model, Food food) {
        if (foodService.addFood(food) < 1) {
            model.addAttribute("error message", String.format("could not add %s", food.getName()));
        }
        model.addAttribute("Success Message", String.format("Successfully added %s", food.getName()));
        return "home";
    }
    @GetMapping("/home")
    public String getHome(Model model){
        model.addAttribute("message","Hey! Welcome to my food cart");
        Food[] foods = foodService.getFoods();
        model.addAttribute("foods",foods);
        return "home";
    }
}
