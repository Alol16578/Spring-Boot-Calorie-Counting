package com.caloriecounting.demo;

import com.caloriecounting.demo.model.Food;
import com.caloriecounting.demo.model.Intake;
import com.caloriecounting.demo.model.User;
import com.caloriecounting.demo.repository.FoodRepository;
import com.caloriecounting.demo.repository.IntakeRepository;
import com.caloriecounting.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

@Component
public class DataBaseInitializer implements CommandLineRunner {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IntakeRepository intakeRepository;

    @Override
    public void run(String... args) throws Exception {
        // Sample FOODS
        Food apple = new Food("Apple", 95);
        Food banana = new Food("Banana", 105);
        Food orange = new Food("Orange", 62);

        foodRepository.save(apple);
        foodRepository.save(banana);
        foodRepository.save(orange);

        // Sample USERS
        User user = new User();
        user.setUsername("user");
        user.setPassword("password");
        user.setEmail("user@example.com");

        userRepository.save(user);

        User user2 = new User();
        user2.setUsername("user2");
        user2.setPassword("password2");
        user2.setEmail("user2@example.com");

        userRepository.save(user2);

        // Create intake records for the past week
        List<Intake> intakes = new ArrayList<>();
        LocalDate today = LocalDate.now();

        for (int i = 6; i > 0; i--) {
            LocalDate date = today.minusDays(i);

            Intake intake = new Intake();
            intake.setDate(date);
            intake.setUser(user);
            intake.setFood(apple);

            intakes.add(intake);
        }

        intakeRepository.saveAll(intakes);
    }
}
