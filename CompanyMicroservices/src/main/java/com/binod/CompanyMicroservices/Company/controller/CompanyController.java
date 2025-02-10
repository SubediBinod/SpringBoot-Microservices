package com.binod.CompanyMicroservices.Company.controller;


import com.binod.CompanyMicroservices.Company.entity.Company;
import com.binod.CompanyMicroservices.Company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService service;

    @GetMapping
    public ResponseEntity<?> getCompanies() {
        List<Company> companies = service.getCompany();
        return ResponseEntity.ok(companies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCompany(@PathVariable int id) {
        Company company = service.getCompany(id);
        return (company != null)
                ? ResponseEntity.ok(company)
                : ResponseEntity.badRequest().body("Company not found");
    }

    @PostMapping
    public ResponseEntity<?> createCompany(@RequestBody Company company) {
        boolean status = service.createCompany(company);
        return status
                ? ResponseEntity.ok("Successfully created")
                : ResponseEntity.badRequest().body("Failed to create");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCompany(@RequestBody Company updatedCompany, @PathVariable int id) {
        boolean status = service.updateCompany(updatedCompany, id);
        return status
                ? ResponseEntity.ok("Successfully updated Company")
                : ResponseEntity.badRequest().body("Failed to update");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable int id) {
        boolean status = service.deleteCompany(id);
        return status
                ? ResponseEntity.ok("Successfully deleted company")
                : ResponseEntity.badRequest().body("Failed to delete");
    }
}
