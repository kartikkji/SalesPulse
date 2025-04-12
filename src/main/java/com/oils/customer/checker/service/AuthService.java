package com.oils.customer.checker.service;


import com.oils.customer.checker.dto.requestDto.EmployeesReqDto;
import com.oils.customer.checker.dto.responseDto.EmployeesResDto;
import com.oils.customer.checker.entity.Employees;
import com.oils.customer.checker.exceptions.PhoneNumberAlreadyRegister;
import com.oils.customer.checker.repo.EmployeeRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private InquiryService inquiryService;


    public ResponseEntity<String> saveEmployee( EmployeesReqDto employeesReqDto){

        if(employeeRepo.findByPhoneNumber(employeesReqDto.getPhoneNumber()) != null){
            throw new PhoneNumberAlreadyRegister("Phone number already register please try another number");
        }

        if(employeeRepo.findByEmail(employeesReqDto.getEmail()) != null){
            throw new PhoneNumberAlreadyRegister("Email already register please try another Email");
        }

        Employees employees = new Employees();

        employees.setEmail(employeesReqDto.getEmail());
        employees.setRole(employeesReqDto.getRole());
        employees.setPhoneNumber(employeesReqDto.getPhoneNumber());
        employees.setName(employeesReqDto.getName());

        employees = employeeRepo.save(employees);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Employee registered successfully!");



    }
}
