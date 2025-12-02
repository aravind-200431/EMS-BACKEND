package com.example.ems_backend.Controller;

import com.example.ems_backend.Entity.Employee;
import com.example.ems_backend.Service.Emsservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/employee")
public class Emscontroller
{

    @Autowired
    Emsservice emsservice;
    @PostMapping("/add")
    public String addemployyee(@RequestBody Employee employee)
    {
        emsservice.addemployee(employee);
        return "Employee added successfully";

    }
    @GetMapping("/all")
    public List<Employee> getemployeeall()
    {
         return emsservice.getallemployee();

    }
    @DeleteMapping("/deleteall")
    public String deleteemployeeall()
    {
         emsservice.deleteallemployee();
         return "Employee deleted successfully";
    }
    @GetMapping("/getbyid/{id}")
     public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        List<Employee> employees = emsservice.getallemployee();
        for (Employee emp : employees) {
            if (emp.getId().equals(id)) {
                return ResponseEntity.ok(emp);
            }
        }
        return ResponseEntity.notFound().build();

     }
    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
        boolean deleted = emsservice.deleteEmployeeById(id);
        if (deleted) {
            return ResponseEntity.ok("Employee deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Employee not found");
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployeeById(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
            List<Employee> employees = emsservice.getallemployee();
            for (Employee emp : employees) {
                if (emp.getId().equals(id)) {
                    emp.setEmployee_name(updatedEmployee.getEmployee_name());
                    emp.setEmployee_role(updatedEmployee.getEmployee_role());
                    emp.setGender(updatedEmployee.getGender());
                    emsservice.addemployee(emp);
                    return ResponseEntity.ok("Employee updated successfully");
                }
            }
            return ResponseEntity.status(404).body("Employee not found");
        }



}
