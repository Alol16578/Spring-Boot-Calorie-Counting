package com.caloriecounting.demo.controller;

import com.caloriecounting.demo.model.Food;
import com.caloriecounting.demo.model.User;
import com.caloriecounting.demo.repository.FoodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AddFoodController {
    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/add-food")
    public String addFoodForm(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) 
            return "redirect:/login";
        model.addAttribute("food", new Food());
        return "add-food";
    }

    @PostMapping("/add-food")
    public String registerUserAccount(@ModelAttribute("food") @Valid Food food,
                                      BindingResult result) {
        if (result.hasErrors()) {
            return "add-food";
        }

        foodRepository.save(food);
        return "redirect:/add-food?success";
    }

}
