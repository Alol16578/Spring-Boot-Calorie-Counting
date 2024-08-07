package com.caloriecounting.demo.controller;

import com.caloriecounting.demo.model.Intake;
import com.caloriecounting.demo.model.User;
import com.caloriecounting.demo.repository.IntakeRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IntakeRepository intakeRepository;

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) 
            return "redirect:/login";

        List<Intake> intakes = intakeRepository.findByUser(user);
        List<Intake> todayIntakes = intakeRepository.findByUserAndDate(user, LocalDate.now());
        int todayCalories = 0;
        for (Intake intake: todayIntakes)
            todayCalories += intake.getFood().getCalories();
        model.addAttribute("intakes", intakes);
        model.addAttribute("todayIntakes", todayIntakes);
        model.addAttribute("todayCalories", todayCalories);

        return "home";
    }


}