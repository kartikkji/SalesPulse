package com.oils.customer.checker.service;


import com.oils.customer.checker.dto.requestDto.InquiryReqDTO;
import com.oils.customer.checker.dto.responseDto.InquiryResDTO;
import com.oils.customer.checker.entity.Inquiry;
import com.oils.customer.checker.exceptions.PhoneNumberAlreadyRegister;
import com.oils.customer.checker.repo.InquiryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InquiryService {

    @Autowired
    private InquiryRepo inquiryRepo;



    public ResponseEntity<InquiryResDTO> saveNumber(InquiryReqDTO inquiryReqDTO){
        if(inquiryRepo.findByPhoneNumber(inquiryReqDTO.getPhoneNumber()) != null){
            throw new PhoneNumberAlreadyRegister("This phone number already exists.");
        }

        Inquiry inquiry = Inquiry.builder()
                .phoneNumber(inquiryReqDTO.getPhoneNumber())
                .name(inquiryReqDTO.getName())
                .date(LocalDate.now())
                .state(inquiryReqDTO.getState())
                .employees(inquiryReqDTO.getEmployees())
                .build();

        inquiry =  inquiryRepo.save(inquiry);

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
}
