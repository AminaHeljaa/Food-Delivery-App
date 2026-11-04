package org.example.food.controller;

import org.example.food.model.Review;
import org.example.food.model.ReviewForm;
import org.example.food.model.meal;
import org.example.food.model.restaurant;
import org.example.food.repository.MealRepository;
import org.example.food.repository.RestaurantRepository;
import org.example.food.repository.ReviewRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class appcontroller {

    private final RestaurantRepository restaurantRepository;
    private final MealRepository mealRepository;
    private final ReviewRepository reviewRepository;

    public appcontroller(
            RestaurantRepository restaurantRepository,
            MealRepository mealRepository,
            ReviewRepository reviewRepository) {

        this.restaurantRepository = restaurantRepository;
        this.mealRepository = mealRepository;
        this.reviewRepository = reviewRepository;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/a";
    }

    // RESTORANI
    @GetMapping("/a")
    public String listRestaurant(Model model) {
        model.addAttribute("restaurants", restaurantRepository.findAll());
        return "listA";
    }

    @PostMapping("/restaurants/add")
    public String addRestaurant(
            @RequestParam String name,
            @RequestParam String city,
            @RequestParam String cuisine,
            @RequestParam double rating,
            @RequestParam(required = false) String imageUrl) {

        restaurant newRestaurant =
                new restaurant(name, city, cuisine, rating);

        newRestaurant.setImageUrl(imageUrl);

        restaurantRepository.save(newRestaurant);

        return "redirect:/a";
    }

    // JELA
    @GetMapping("/b")
    public String listMeals(Model model) {
        model.addAttribute("meals", mealRepository.findAll());
        model.addAttribute("restaurants", restaurantRepository.findAll());
        return "listB";
    }

    @PostMapping("/meals/add")
    public String addMeal(
            @RequestParam String name,
            @RequestParam String category,
            @RequestParam double price,
            @RequestParam(defaultValue = "false") boolean vegetarian,
            @RequestParam Long restaurantId,
            @RequestParam(required = false) String imageUrl) {

        restaurant selectedRestaurant =
                restaurantRepository.findById(restaurantId).orElse(null);

        if (selectedRestaurant != null) {
            meal newMeal = new meal();

            newMeal.setName(name);
            newMeal.setCategory(category);
            newMeal.setPrice(price);
            newMeal.setVegetarian(vegetarian);
            newMeal.setImageUrl(imageUrl);
            newMeal.setRestaurant(selectedRestaurant);

            mealRepository.save(newMeal);
        }

        return "redirect:/b";
    }

    // RECENZIJE
    @GetMapping("/reviews")
    public String listReviews(Model model) {
        model.addAttribute("reviews", reviewRepository.findAll());
        return "reviews";
    }

    @GetMapping("/reviews/new")
    public String newReview(Model model) {
        model.addAttribute("reviewForm", new ReviewForm());
        model.addAttribute("restaurants", restaurantRepository.findAll());
        return "review-form";
    }

    @PostMapping("/reviews")
    public String saveReview(
            @ModelAttribute("reviewForm") ReviewForm form) {

        if (form.getRestaurantId() != null) {
            restaurant selectedRestaurant =
                    restaurantRepository.findById(form.getRestaurantId()).orElse(null);

            if (selectedRestaurant != null) {
                Review review = new Review();

                review.setAuthor(form.getAuthor());
                review.setComment(form.getComment());
                review.setRating(form.getRating());
                review.setRestaurant(selectedRestaurant);

                reviewRepository.save(review);
            }
        }

        return "redirect:/reviews";
    }

    @GetMapping("/reviews/edit/{id}")
    public String editReview(@PathVariable Long id, Model model) {

        Review review = reviewRepository.findById(id).orElse(null);

        if (review == null) {
            return "redirect:/reviews";
        }

        ReviewForm form = new ReviewForm();

        form.setId(review.getId());
        form.setAuthor(review.getAuthor());
        form.setComment(review.getComment());
        form.setRating(review.getRating());

        if (review.getRestaurant() != null) {
            form.setRestaurantId(review.getRestaurant().getId());
        }

        model.addAttribute("reviewForm", form);
        model.addAttribute("restaurants", restaurantRepository.findAll());

        return "review-form";
    }

    @PostMapping("/reviews/update/{id}")
    public String updateReview(
            @PathVariable Long id,
            @ModelAttribute("reviewForm") ReviewForm form) {

        Review review = reviewRepository.findById(id).orElse(null);

        if (review != null && form.getRestaurantId() != null) {
            restaurant selectedRestaurant =
                    restaurantRepository.findById(form.getRestaurantId()).orElse(null);

            if (selectedRestaurant != null) {
                review.setAuthor(form.getAuthor());
                review.setComment(form.getComment());
                review.setRating(form.getRating());
                review.setRestaurant(selectedRestaurant);

                reviewRepository.save(review);
            }
        }

        return "redirect:/reviews";
    }
}
