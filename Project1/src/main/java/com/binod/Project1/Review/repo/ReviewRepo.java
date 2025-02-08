package com.binod.Project1.Review.repo;

import com.binod.Project1.Review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {
    List<Review> findByCompanyId(int companyId); // Find reviews by companyId
    Optional<Review> findByIdAndCompanyId(int reviewId, int companyId); // Find specific review by companyId and reviewId
}
