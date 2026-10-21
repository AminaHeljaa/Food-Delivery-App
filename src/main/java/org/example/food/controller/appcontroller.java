package org.example.food.controller;
import org.example.food.data.demodata;
import org.example.food.model.restaurant;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class appcontroller {
    @GetMapping ("/")
    public String home (){
        return "redirect:/a";

    }
    @GetMapping ("/a")
    public String listRestaurant (Model model){
        model.addAttribute("restaurants",demodata.restaurants);
        return "listA";
    }
    @GetMapping ("/b")
    public String listMeals(Model model){
        model.addAttribute("meals",demodata.meals);
        return "listB";
    }
    @GetMapping("/a/action/{id}")
    public String restaurantAction (@PathVariable int id, Model model){
        restaurant selectedRestaurant =null;
        for (restaurant restaurant:demodata.restaurants){
            if (restaurant.getId()==id){
                selectedRestaurant=restaurant;
                break;
            }
        }
        if (selectedRestaurant ==null){
            return "redirect:/a";
        }
        model.addAttribute("restaurant",selectedRestaurant);
        return "action";
    }
}