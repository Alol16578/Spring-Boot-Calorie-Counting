package com.caloriecounting.demo.repository;

import com.caloriecounting.demo.model.Intake;
import com.caloriecounting.demo.model.User;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IntakeRepository extends JpaRepository<Intake, Long> {
    List<Intake> findByUser(User user);
    
    @Query("SELECT i FROM Intake i WHERE i.user = :user AND i.date = :date")
    List<Intake> findByUserAndDate(@Param("user") User user, @Param("date") LocalDate date);
}
