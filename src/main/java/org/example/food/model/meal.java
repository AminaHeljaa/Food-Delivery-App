package org.example.food.model;

import jakarta.persistence.*;

@Entity
public class meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private double price;
    private boolean vegetarian;

    // Automatski pronađena fotografija jela
    @Column(length = 1000)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private restaurant restaurant;

    public meal() {
    }

    public meal(String name, String category, double price,
                boolean vegetarian, restaurant restaurant) {

        this.name = name;
        this.category = category;
        this.price = price;
        this.vegetarian = vegetarian;
        this.restaurant = restaurant;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(restaurant restaurant) {
        this.restaurant = restaurant;
    }
}