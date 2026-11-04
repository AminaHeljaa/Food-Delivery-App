package org.example.food.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String cuisine;
    private double rating;


    private String imageUrl;


    @OneToMany(mappedBy = "restaurant",
            cascade = CascadeType.ALL)
    private List<meal> meals = new ArrayList<>();

    public restaurant() {
    }

    public restaurant(String name, String city,
                      String cuisine, double rating) {

        this.name = name;
        this.city = city;
        this.cuisine = cuisine;
        this.rating = rating;
    }

    // GETTERI I SETTERI

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<meal> getMeals() {
        return meals;
    }

    public void setMeals(List<meal> meals) {
        this.meals = meals;
    }

    public void addmeal(meal meal) {
        meals.add(meal);
        meal.setRestaurant(this);
    }
}