package com.oils.customer.checker.service;


import com.oils.customer.checker.dto.responseDto.EmployeeInquiryRes;
import com.oils.customer.checker.dto.responseDto.EmployeesResDto;
import com.oils.customer.checker.dto.responseDto.InquiryResDTO;
import com.oils.customer.checker.entity.Employees;
import com.oils.customer.checker.entity.Inquiry;
import com.oils.customer.checker.exceptions.EmployeeNotFound;
import com.oils.customer.checker.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private InquiryService inquiryService;


    public Employees findBYEmail(String email){
        return employeeRepo.findByEmail(email);
    }




    public ResponseEntity<EmployeesResDto> fndById(Long ID){
        if(employeeRepo.findById(ID).isEmpty()){
            throw new EmployeeNotFound("Employee Not Found");
        }

        Optional<Employees> employees = employeeRepo.findById(ID);



        return ResponseEntity.ok(EmployeesResDto.builder()
                .phoneNumber(employees.get().getPhoneNumber())
                .name(employees.get().getName())
                .role(employees.get().getRole())
                .email(employees.get().getEmail())
                .inquiries(inquiryService.inquiryToEmployeeInquiryRes(employees.get().getInquiries()))
                .id(employees.get().getId())
                .build()
        );
    }



}
