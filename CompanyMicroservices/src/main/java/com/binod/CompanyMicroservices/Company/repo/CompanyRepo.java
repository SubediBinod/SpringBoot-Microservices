package com.binod.CompanyMicroservices.Company.repo;


import com.binod.CompanyMicroservices.Company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company,Integer> {


}
