package com.binod.Project1.Review.repo;

import com.binod.Project1.Review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ReviewRepo extends JpaRepository<Review, Integer> {

}
