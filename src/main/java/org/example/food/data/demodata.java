package org.example.food.data;

import java.util.ArrayList;
import java.util.List;
import org.example.food.model.meal;
import org.example.food.model.restaurant;

public class demodata {
    public static final List<restaurant> restaurants = new ArrayList<>();
    public static final List<meal> meals= new ArrayList<>();
    static {
        restaurant r1= new restaurant(1, "Burger House","Sarajevo","Fast food",4.8);
        restaurant r2= new restaurant(2, "Italiano","Mostar", "Italian", 3.6);
        restaurant r3= new restaurant (3, "City Burger","Zenica", "Fast food", 4.0);

        restaurants.add(r1);
        restaurants.add(r2);
        restaurants.add(r3);
        meal m1 = new meal (1,"Classic Burger", "Burger", 8.5,false,r1);
        meal m2 = new meal (2,"Cheese Burger", "Burger", 9.5,false,r2);
        meal m3= new meal (3, "Margarita","Pizza",10.0,true,r2);
        meal m4 = new meal (4, "Pasta Carbonara", "Pasta",12.5,false,r2);
        meal m5 = new meal (5, "Vegan Salad","Salad",7.5,true,r3);
        meal m6 = new meal (6, "Veggie Bowl", "Healthy meal",9, true, r3);

        meals.add(m1);
        meals.add(m2);
        meals.add(m3);
        meals.add(m4);
        meals.add(m5);
        meals.add(m6);
        r1.addmeal(m1);
        r1.addmeal(m2);
        r2.addmeal(m3);
        r2.addmeal(m4);
        r3.addmeal(m5);
        r3.addmeal(m6);
    }
}
