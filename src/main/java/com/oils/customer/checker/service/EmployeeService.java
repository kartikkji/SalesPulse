package com.oils.customer.checker.service;


import com.oils.customer.checker.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepo employeeRepo;



}
