package com.example.ems_backend.Repositry;

import com.example.ems_backend.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Emsrepo extends JpaRepository<Employee,Long>
{


}
