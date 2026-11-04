package org.example.food.repository;

import org.example.food.model.meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository
        extends JpaRepository<meal, Long> {
}