package com.caloriecounting.demo.controller;

import com.caloriecounting.demo.model.Food;
import com.caloriecounting.demo.model.Intake;
import com.caloriecounting.demo.model.User;
import com.caloriecounting.demo.repository.FoodRepository;
import com.caloriecounting.demo.repository.IntakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class IntakeController {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private IntakeRepository intakeRepository;

    @GetMapping("/add-calories")
    public String addCaloriesForm(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("foods", foodRepository.findAll());
        model.addAttribute("intake", new Intake());
        return "add-calories";
    }

    @PostMapping("/add-calories")
    public String addCalories(@RequestParam Long foodId,  HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }
        Food food = foodRepository.findById(foodId).orElse(null);
        if (food != null) {
            Intake intake = new Intake();
            intake.setUser(user);
            intake.setDate(LocalDate.now());
            intake.setFood(food);
            intakeRepository.save(intake);
        }
        return "redirect:/home";
    }
}