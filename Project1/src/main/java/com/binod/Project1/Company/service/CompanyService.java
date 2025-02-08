package com.binod.Project1.Company.service;

import com.binod.Project1.Company.entity.Company;
import com.binod.Project1.Company.repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    CompanyRepo repo;

    public List<Company> getCompany(){
        List<Company>companies= repo.findAll();
        return companies;
    }
    public boolean updateCompany(Company updatedCompany,int id){
        Optional<Company>companies= repo.findById(id);
        if(companies.isPresent()){
            Company company= new Company();
            company.setId(updatedCompany.getId());
            company.setName(updatedCompany.getName());
            company.setDescription(updatedCompany.getDescription());
            company.setJobList(updatedCompany.getJobList());
            company.setReviewList(updatedCompany.getReviewList());
            company.setReviewList(updatedCompany.getReviewList());
            return true;
        }
        return false;

    }
    public boolean createCompany(Company company){
        try {
            repo.save(company);
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;

    }
    public  boolean deleteCompany(int id){
        Optional<Company>companies= repo.findById(id);
        if(companies.isPresent()){
            repo.deleteById(id);
            return true;
        }
        return false;

    }
    public Company getCompany(int id){
        Optional<Company>companies= repo.findById(id);
        return companies.orElse(null);
    }
}
