package org.example.food.model;

public class meal {
    private int id;
    private String name;
    private String category;
    private double price;
    private boolean vegetarian;
    private restaurant restaurant;

    public meal(int id, String name, String category, double price, boolean vegetarian, restaurant restaurant) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.vegetarian = vegetarian;
        this.restaurant = restaurant;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public restaurant getRestaurant() {
        return restaurant;
    }
}