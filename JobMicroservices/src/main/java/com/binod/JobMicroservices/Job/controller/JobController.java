package com.binod.JobMicroservices.Job.controller;

import com.binod.JobMicroservices.Job.dto.JobCompanyReviewResponseDto;
import com.binod.JobMicroservices.Job.entity.Job;
import com.binod.JobMicroservices.Job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class JobController {
    @Autowired
    JobService service;
    @GetMapping("/jobs")
    public ResponseEntity<?> getJobs(){
        List<Job> job=service.findJobs();
        if(job.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(job);

    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<?> getJobById(@PathVariable Integer id) {
        return service.findJobsById(id); // Now it returns ResponseEntity
    }
    @PostMapping("/jobs")
    public ResponseEntity<?> createJob(@RequestBody Job job){
       service.createJob(job);
     return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/jobs/{id}")
    public  ResponseEntity<?> deleteJob(@PathVariable int id){
        String message= service.deleteJob(id);
        return ResponseEntity.ok().body(message);

    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<?> updateJob(@RequestBody Job updatedJob, @PathVariable int id){
        String message= service.updateJob(updatedJob,id);
        return ResponseEntity.ok().body(message);

    }
}
