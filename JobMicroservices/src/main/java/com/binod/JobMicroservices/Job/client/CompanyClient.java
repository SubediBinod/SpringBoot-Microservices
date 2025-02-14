package com.binod.JobMicroservices.Job.client;

import com.binod.JobMicroservices.Job.dto.CompanyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CompanyMicroservices")
public interface CompanyClient {
    @GetMapping("/companies/{id}")
    CompanyDto getCompany(@PathVariable int id);
}
