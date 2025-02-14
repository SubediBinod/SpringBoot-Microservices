package com.binod.ReviewMicroservices.Review.controller;

import com.binod.ReviewMicroservices.Review.entity.Review;
import com.binod.ReviewMicroservices.Review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    ReviewService service;


    // Get reviews for a specific company
    @GetMapping
    public ResponseEntity<List<Review>> getReviews(@RequestParam int companyId) {
        List<Review> reviews = service.getReviewsByCompanyId(companyId);
        return ResponseEntity.ok(reviews);
    }

    // Create a new review for a company
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestParam int companyId, @RequestBody Review review) {
        Review createdReview = service.createReview(companyId, review);
        return ResponseEntity.status(201).body(createdReview);
    }

    // Get a specific review for a company
    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview( @PathVariable int reviewId) {
        Review review = service.getReview( reviewId);
        return ResponseEntity.ok(review);
    }

    // Update an existing review for a company
    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview( @PathVariable int reviewId, @RequestBody Review review) {
        Review updatedReview = service.updateReview(reviewId, review);
        return ResponseEntity.ok(updatedReview);
    }

    // Delete a specific review for a company
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview( @PathVariable int reviewId) {
        service.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }
}
