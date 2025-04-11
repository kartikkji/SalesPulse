package com.oils.customer.checker.service;


import com.oils.customer.checker.entity.Employees;
import com.oils.customer.checker.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepo employeeRepo;


    public Employees findBYEmail(String email){
        return employeeRepo.findByEmail(email);
    }



}
