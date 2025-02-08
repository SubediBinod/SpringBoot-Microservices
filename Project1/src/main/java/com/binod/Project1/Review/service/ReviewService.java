package com.binod.Project1.Review.service;

import com.binod.Project1.Review.entity.Review;
import com.binod.Project1.Review.repo.ReviewRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepo reviewRepo;

    public ReviewService(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    // Get reviews for a specific company
    public List<Review> getReviewsByCompanyId(int companyId) {
        return reviewRepo.findByCompanyId(companyId);
    }

    // Create a new review for a company
    public Review createReview(int companyId, Review review) {
        review.getCompany().setId(companyId); // Link the review to the company
        return reviewRepo.save(review);
    }

    // Get a specific review by company and reviewId
    public Review getReview(int companyId, int reviewId) {
        return reviewRepo.findByIdAndCompanyId(reviewId, companyId)
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }

    // Update an existing review
    public Review updateReview(int companyId, int reviewId, Review review) {
        Review existingReview = getReview(companyId, reviewId);
        existingReview.setTitle(review.getTitle());
        existingReview.setDescription(review.getDescription());
        existingReview.setRating(review.getRating());
        return reviewRepo.save(existingReview);
    }

    // Delete a specific review
    public void deleteReview(int companyId, int reviewId) {
        Review review = getReview(companyId, reviewId);
        reviewRepo.delete(review);
    }
}
