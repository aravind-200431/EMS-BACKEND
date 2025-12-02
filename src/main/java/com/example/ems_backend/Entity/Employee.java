package com.example.ems_backend.Entity;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String employee_name;
    private String employee_role;
    private String gender;

}
