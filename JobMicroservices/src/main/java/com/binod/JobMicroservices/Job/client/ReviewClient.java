package com.binod.JobMicroservices.Job.client;

import com.binod.JobMicroservices.Job.dto.ReviewDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ReviewMicroservices")
public interface ReviewClient {
    @GetMapping("/reviews")
    List<ReviewDto> getReview(@RequestParam int companyId);
}

