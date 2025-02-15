package com.binod.Project1.Job.entity;

import com.binod.Project1.Company.entity.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String empName;
    int age;
    BigDecimal salary; // Changed to BigDecimal for better financial representation
    String address;

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", salary='" + salary + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
