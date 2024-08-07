package com.caloriecounting.demo.model;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Food name is required")
    private String name;

    @Min(value = 0, message = "Calories must be positive")
    private int calories;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private Set<Intake> intakes;

    public Food() {}

    public Food(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Set<Intake> getIntakes() {
        return intakes;
    }

    public void setIntakes(Set<Intake> intakes) {
        this.intakes = intakes;
    }
}