package com.binod.JobMicroservices.Job.dto;

import com.binod.JobMicroservices.Job.entity.Job;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobCompanyReviewResponseDto {
    private Job job;
    private CompanyDto company;
    private List<ReviewDto> review;
}
