package org.example.food.controller;

import org.example.food.model.restaurant;
import org.example.food.model.Review;
import org.example.food.repository.RestaurantRepository;
import org.example.food.repository.ReviewRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewRestController {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    public ReviewRestController(
            ReviewRepository reviewRepository,
            RestaurantRepository restaurantRepository) {

        this.reviewRepository = reviewRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping
    public List<ReviewResponse> getAllReviews() {

        return reviewRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponse> getReview(
            @PathVariable Long id) {

        return reviewRepository.findById(id)
                .map(review ->
                        ResponseEntity.ok(toResponse(review)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createReview(
            @RequestBody ReviewRequest request) {

        if (request.rating() == null ||
                request.rating() < 1 ||
                request.rating() > 5 ||
                request.restaurantId() == null) {

            return ResponseEntity.badRequest()
                    .body("Invalid review data.");
        }

        restaurant restaurant = restaurantRepository
                .findById(request.restaurantId())
                .orElse(null);

        if (restaurant == null) {
            return ResponseEntity.badRequest()
                    .body("Restaurant not found.");
        }

        Review review = new Review();

        review.setAuthor(request.author());
        review.setComment(request.comment());
        review.setRating(request.rating());
        review.setRestaurant(restaurant);
        review.setCreatedAt(LocalDate.now());

        Review saved = reviewRepository.save(review);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(toResponse(saved));
    }

    private ReviewResponse toResponse(Review review) {

        return new ReviewResponse(
                (long) review.getId(),
                review.getAuthor(),
                review.getComment(),
                review.getRating(),
                review.getCreatedAt(),
                (long) review.getRestaurant().getId(),
                review.getRestaurant().getName()
        );
    }

    public record ReviewRequest(
            String author,
            String comment,
            Integer rating,
            Long restaurantId
    ) {}

    public record ReviewResponse(
            Long id,
            String author,
            String comment,
            int rating,
            LocalDate createdAt,
            Long restaurantId,
            String restaurantName
    ) {}
}