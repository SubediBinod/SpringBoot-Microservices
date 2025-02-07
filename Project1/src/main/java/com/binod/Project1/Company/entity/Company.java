package com.binod.Project1.Company.entity;


import com.binod.Project1.Job.entity.Job;
import com.binod.Project1.Review.entity.Review;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Company {
    private int id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "company")
    private List<Job> jobList;

    @OneToMany(mappedBy = "company")
    private List<Review> reviewList;

}
