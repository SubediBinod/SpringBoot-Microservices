package com.binod.Project1.Company.controller;

import com.binod.Project1.Company.entity.Company;
import com.binod.Project1.Company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    CompanyService service;
    @GetMapping("/companies")
        public ResponseEntity<?>getCompanies(){
        List<Company> companies= service.getCompany();
        return ResponseEntity.ok().body(companies);
    }
    @PutMapping("/companies/{id}")
    public  ResponseEntity<?>updateCompany(@RequestBody Company updatedCompany,@RequestParam int id){
        boolean status= service.updateCompany(updatedCompany,id);
        if(status){
            return ResponseEntity.ok().body("Successfully updated Company");
        }
        return ResponseEntity.badRequest().body("Failed to updated");


    }
    @PostMapping("/companies")
    public  ResponseEntity<?>createCompany(@RequestBody Company company){
        boolean status =service.createCompany(company);
        if(status){
            return ResponseEntity.ok().body("Successfully created ");
        }
        return ResponseEntity.badRequest().body("Failed to create ");


    }
    @DeleteMapping("/companies/{id}")
    public ResponseEntity<?>deleteCompany(@RequestParam int id){
        boolean status=service.deleteCompany(id);
        if(status){
            return ResponseEntity.ok().body("successfully deleted company");

        }
        return ResponseEntity.badRequest().body("Failed to delete");

    }
    @GetMapping("/companies/{id}")
    public ResponseEntity<?>getCompanies(@RequestParam int id){
        Company company=service.getCompany(id);
       return ResponseEntity.ok().body(company);

    }
}
