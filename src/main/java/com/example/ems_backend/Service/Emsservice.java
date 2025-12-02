package com.example.ems_backend.Service;

import com.example.ems_backend.Entity.Employee;
import com.example.ems_backend.Repositry.Emsrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Emsservice
{
    @Autowired
    Emsrepo emsrepo;
    public void addemployee( Employee employee )
    {
         emsrepo.save(employee);


    }
    public List<Employee> getallemployee()
    {
         return emsrepo.findAll();
    }

    public void deleteallemployee()
    {
            emsrepo.deleteAll();
    }


    public Boolean deleteEmployeeById(Long id)
    {
        if(emsrepo.existsById(id))
        {
            emsrepo.deleteById(id);
            return true;
        }
        else
        {
            return false;
        }
    }
}
