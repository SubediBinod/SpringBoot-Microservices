package com.binod.Project1.Review.entity;


import com.binod.Project1.Company.entity.Company;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Review {
    private int id;
    private String title;
    private String description;
    private double rating;

    @ManyToOne()
    @JoinColumn(name = "Company_id")
    private Company company;




}
