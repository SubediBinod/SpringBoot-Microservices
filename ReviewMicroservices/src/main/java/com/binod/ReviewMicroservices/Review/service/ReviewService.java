package com.binod.ReviewMicroservices.Review.service;

import com.binod.ReviewMicroservices.Review.entity.Review;
import com.binod.ReviewMicroservices.Review.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepo reviewRepo;
    // Get reviews for a specific company
    public List<Review> getReviewsByCompanyId(int companyId) {
        return reviewRepo.findByCompanyId(companyId);
    }

    // Create a new review for a company
    public Review createReview(int companyId, Review review) {
        review.setCompanyId(companyId); // Link the review to the company
        return reviewRepo.save(review);
    }

    public Review getReview( int reviewId) {
        return reviewRepo.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }

    // Update an existing review
    public Review updateReview(int reviewId, Review review) {
        Review existingReview = getReview( reviewId);
        existingReview.setTitle(review.getTitle());
        existingReview.setDescription(review.getDescription());
        existingReview.setRating(review.getRating());
        return reviewRepo.save(existingReview);
    }

    // Delete a specific review
    public void deleteReview(int reviewId) {
        Review review = getReview(reviewId);
        reviewRepo.delete(review);
    }
}
