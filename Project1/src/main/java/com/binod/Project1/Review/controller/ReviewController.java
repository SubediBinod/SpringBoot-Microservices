package com.binod.Project1.Review.controller;

import com.binod.Project1.Review.entity.Review;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    @GetMapping("/reviews")
    public ResponseEntity<?> getReviews(){

    }
    @PostMapping("/reviews")
    public ResponseEntity<?> createReview(){

    }
    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<?> getReview(){

    }
    @PutMapping("/reviews/{reviewId}")
    public  ResponseEntity<?> updateReview()
    }

    @DeleteMapping("/reviews/{reviewId}")
     public ResponseEntity<?> deleteReview() {
    }



}
