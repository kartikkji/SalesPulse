package com.oils.customer.checker.service;


import com.oils.customer.checker.dto.requestDto.InquiryReqDTO;
import com.oils.customer.checker.dto.responseDto.InquiryResDTO;
import com.oils.customer.checker.entity.Employees;
import com.oils.customer.checker.entity.Inquiry;
import com.oils.customer.checker.exceptions.EmployeeNotFound;
import com.oils.customer.checker.exceptions.PhoneNumberAlreadyRegister;
import com.oils.customer.checker.repo.InquiryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InquiryService {

    @Autowired
    private InquiryRepo inquiryRepo;

    @Autowired
    private EmployeeService employeeService;



    public ResponseEntity<?> saveNumber(InquiryReqDTO inquiryReqDTO){
        if (inquiryRepo.findByPhoneNumber(inquiryReqDTO.getPhoneNumber()) != null) {
            throw new PhoneNumberAlreadyRegister("This phone number already exists.");
        }

        // Avoid calling twice
        Employees employees = employeeService.findBYEmail(inquiryReqDTO.getEmployeeEmail());
        if (employees == null) {
            throw new EmployeeNotFound("Employee not Found.");
        }

        Inquiry inquiry = Inquiry.builder()
                .phoneNumber(inquiryReqDTO.getPhoneNumber())
                .name(inquiryReqDTO.getName())
                .date(LocalDate.now())
                .state(inquiryReqDTO.getState())
                .employees(employees) // Use the already fetched employee
                .build();

        inquiry = inquiryRepo.save(inquiry);

        return ResponseEntity.ok(
                InquiryResDTO.builder()
                        .phoneNumber(inquiry.getPhoneNumber())
                        .name(inquiry.getName())
                        .state(inquiry.getState())
                        .employees(inquiry.getEmployees())
                        .date(inquiry.getDate())
                        .build()
        );
    }


    public ResponseEntity<?> checkInquiry(Long phoneNumber){

        Inquiry inquiry = new Inquiry();
        inquiry = inquiryRepo.findByPhoneNumber(phoneNumber);
        if(inquiry != null){
            return ResponseEntity.ok(
                    InquiryResDTO.builder()
                            .phoneNumber(inquiry.getPhoneNumber())
                            .name(inquiry.getName())
                            .state(inquiry.getState())
                            .employees(inquiry.getEmployees())
                            .date(inquiry.getDate())
                            .build()
            );
        }else{
            Map<String, String> response = new HashMap<>();
            response.put("message", "This phone number is not in inquiry.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


//    public void saveInquiry(Employees employees, List<Inquiry> inquiryList){
//
//    }
}
