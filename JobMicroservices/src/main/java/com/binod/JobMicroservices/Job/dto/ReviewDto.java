package com.binod.JobMicroservices.Job.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewDto {
    private int id;
    private String title;
    private String description;
    private double rating;
    private int companyId;
}
