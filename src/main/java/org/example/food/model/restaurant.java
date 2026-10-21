package org.example.food.model;

import java.util.ArrayList;
import java.util.List;

public class restaurant {
    private int id;
    private String name;
    private String city;
    private String cuisine;
    private double rating;
    private List <meal> meals =new ArrayList<>();

    public restaurant (int id, String name,String city, String cuisine, double rating) {
        this.id=id;
        this.name=name;
        this.city=city;
        this.cuisine= cuisine;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCuisine() {
        return cuisine;
    }

    public double getRating() {
        return rating;
    }

    public List<meal> getMeals() {
        return meals;
    }
    public void addmeal(meal meal){
        meals.add(meal);
    }
}
