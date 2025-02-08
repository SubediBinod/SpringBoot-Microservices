package com.binod.Project1.Review.controller;

import com.binod.Project1.Review.entity.Review;
import com.binod.Project1.Review.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // Get reviews for a specific company
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getReviews(@PathVariable int companyId) {
        List<Review> reviews = reviewService.getReviewsByCompanyId(companyId);
        return ResponseEntity.ok(reviews);
    }

    // Create a new review for a company
    @PostMapping("/reviews")
    public ResponseEntity<Review> createReview(@PathVariable int companyId, @RequestBody Review review) {
        Review createdReview = reviewService.createReview(companyId, review);
        return ResponseEntity.status(201).body(createdReview);
    }

    // Get a specific review for a company
    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable int companyId, @PathVariable int reviewId) {
        Review review = reviewService.getReview(companyId, reviewId);
        return ResponseEntity.ok(review);
    }

    // Update an existing review for a company
    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable int companyId, @PathVariable int reviewId, @RequestBody Review review) {
        Review updatedReview = reviewService.updateReview(companyId, reviewId, review);
        return ResponseEntity.ok(updatedReview);
    }

    // Delete a specific review for a company
    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable int companyId, @PathVariable int reviewId) {
        reviewService.deleteReview(companyId, reviewId);
        return ResponseEntity.noContent().build();
    }
}
