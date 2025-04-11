package com.oils.customer.checker.service;


import com.oils.customer.checker.dto.requestDto.EmployeesReqDto;
import com.oils.customer.checker.dto.responseDto.EmployeesResDto;
import com.oils.customer.checker.entity.Employees;
import com.oils.customer.checker.exceptions.PhoneNumberAlreadyRegister;
import com.oils.customer.checker.repo.EmployeeRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private InquiryService inquiryService;


    public ResponseEntity<EmployeesResDto> saveEmployee( EmployeesReqDto employeesReqDto){

        if(employeeRepo.findByPhoneNumber(employeesReqDto.getPhoneNumber()) != null){
            throw new PhoneNumberAlreadyRegister("Phone number already register please try another number");
        }

        Employees employees = new Employees();

        employees.setEmail(employeesReqDto.getEmail());
        employees.setRole(employeesReqDto.getRole());
        employees.setPhoneNumber(employeesReqDto.getPhoneNumber());
        employees.setName(employeesReqDto.getName());

        employees = employeeRepo.save(employees);

        return ResponseEntity.ok(
                EmployeesResDto.builder()
                        .role(employees.getRole())
                        .email(employees.getEmail())
                        .name(employees.getName())
                        .phoneNumber(employees.getPhoneNumber())
                        .id(employees.getId())
                        .build()
        );

    }
}
