package com.binod.Project1.Job.service;

import com.binod.Project1.Job.entity.Job;
import com.binod.Project1.Job.repo.JobRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepo repo;

    public List<Job> findJobs(){
      List <Job> jobs=repo.findAll();
        jobs.forEach(System.out::println);
        return jobs;
    }
    public Job findJobsById(Integer id) {
        Optional<Job> job= repo.findById(id);
        return  job.orElse(null);
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
