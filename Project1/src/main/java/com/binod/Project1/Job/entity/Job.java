package com.binod.Project1.Job.entity;


import com.binod.Project1.Company.entity.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    String salary;
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

    @OneToMany
    @JoinColumn(name = "company_id")
    private Company company;

}
