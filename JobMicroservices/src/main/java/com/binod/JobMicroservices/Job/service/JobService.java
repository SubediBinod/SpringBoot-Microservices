package com.binod.JobMicroservices.Job.service;



import com.binod.JobMicroservices.Job.client.CompanyClient;
import com.binod.JobMicroservices.Job.client.ReviewClient;

import com.binod.JobMicroservices.Job.dto.CompanyDto;
import com.binod.JobMicroservices.Job.dto.JobCompanyReviewResponseDto;
import com.binod.JobMicroservices.Job.dto.ReviewDto;
import com.binod.JobMicroservices.Job.entity.Job;
import com.binod.JobMicroservices.Job.repo.JobRepo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepo repo;
    @Autowired
    private CompanyClient companyClient;
    @Autowired
    private ReviewClient reviewClient;



    @CircuitBreaker(name
    ="companyBreaker")
    public List<Job> findJobs(){
        return repo.findAll();
    }
    public ResponseEntity<?> findJobsById(Integer id) {
        Optional<Job> job = repo.findById(id);

        if (job.isEmpty()) {
            return ResponseEntity.status(404).body("Job not found");

        }

        JobCompanyReviewResponseDto response = CallCompanyReviewMicroservices(job.get());

        return ResponseEntity.ok(response);
    }
    //@CircuitBreaker(name = "companyBreaker", fallbackMethod = "fallbackForCompanyReview") this is for circuit breaker and fallback

    //@Retry(name = "companyBreaker", fallbackMethod = "fallbackForCompanyReview") this is for retry, fallback

    @RateLimiter(name = "companyBreaker", fallbackMethod = "fallbackForCompanyReview") //Ratelimiter and fallback

    private JobCompanyReviewResponseDto CallCompanyReviewMicroservices(Job job) {
        // Fetch company details
        CompanyDto companyDto = companyClient.getCompany(job.getCompanyId());
        System.out.println("Fetching reviews for companyId: " + job.getCompanyId());

        // Fetch reviews using Feign client
        List<ReviewDto> reviewDto = reviewClient.getReview(job.getCompanyId());
        System.out.println("Reviews received: " + reviewDto);

        // Create response object with job, company, and reviews
        JobCompanyReviewResponseDto response = new JobCompanyReviewResponseDto();
        response.setJob(job);
        response.setCompany(companyDto);
        response.setReview(reviewDto);

        return response;
    }
    // Fallback method for circuit breaker
    private JobCompanyReviewResponseDto fallbackForCompanyReview(Job job, Throwable t) {
        System.out.println("Fallback executed due to: " + t.getMessage());

        JobCompanyReviewResponseDto response = new JobCompanyReviewResponseDto();
        response.setJob(job);
        response.setCompany(new CompanyDto()); // Empty company details
        response.setReview(List.of()); // Empty review list

        return response;
    }



    public String deleteJob(Integer id){
        Optional<Job> job =repo.findById(id);
        if(job.isPresent()){
            repo.deleteById(id);
            return "Job with id "+id+"deleted successfully";
        }
        return "Id not found in database";
    }
    public void createJob(Job job)
    {
        repo.save(job);
    }
    public String updateJob(Job updatedJob, int id){
        Optional<Job>job= repo.findById(id);
        if(job.isPresent()){
            Job j= new Job();
            j.setId(updatedJob.getId());
            j.setAge(updatedJob.getAge());
            j.setAddress(updatedJob.getAddress());
            j.setEmpName(updatedJob.getEmpName());
            j.setSalary(updatedJob.getSalary());
            return "Successfully updated "+id;
        }
        return "Id : "+id+"not found";
    }
}
