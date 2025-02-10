package com.binod.CompanyMicroservices.Company.service;



import com.binod.CompanyMicroservices.Company.entity.Company;
import com.binod.CompanyMicroservices.Company.repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepo repo;

    public List<Company> getCompany() {
        return repo.findAll();
    }

    public Company getCompany(int id) {
        return repo.findById(id).orElse(null);
    }

    public boolean createCompany(Company company) {
        try {
            repo.save(company);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCompany(Company updatedCompany, int id) {
        Optional<Company> optionalCompany = repo.findById(id);
        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            company.setName(updatedCompany.getName());
            company.setDescription(updatedCompany.getDescription());
            repo.save(company);
            return true;
        }
        return false;
    }

    public boolean deleteCompany(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
