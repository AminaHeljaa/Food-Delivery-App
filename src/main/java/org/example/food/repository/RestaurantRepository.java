package org.example.food.repository;

import org.example.food.model.restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository
        extends JpaRepository<restaurant, Long> {
}