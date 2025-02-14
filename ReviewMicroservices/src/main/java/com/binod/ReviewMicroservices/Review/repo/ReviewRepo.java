package com.binod.ReviewMicroservices.Review.repo;


import com.binod.ReviewMicroservices.Review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {
    List<Review> findByCompanyId(int companyId); // Find reviews by companyId
    Optional<Review> findById(int reviewId); // Find specific by reviewId
}
