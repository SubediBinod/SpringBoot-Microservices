package com.binod.JobMicroservices.Job.repo;


import com.binod.JobMicroservices.Job.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<Job,Integer> {
}
