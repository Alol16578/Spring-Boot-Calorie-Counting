package com.caloriecounting.demo.repository;

import com.caloriecounting.demo.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}