package com.oils.customer.checker.dto.responseDto;

import com.oils.customer.checker.entity.Employees;
import com.oils.customer.checker.entity.Inquiry;
import com.oils.customer.checker.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeInquiryRes {

    private Long phoneNumber;
    private String name;
    private LocalDate date;
    private State state;

    public EmployeeInquiryRes(Inquiry inquiry){
        this.date = inquiry.getDate();
        this.name = inquiry.getName();
        this.state = inquiry.getState();
        this.phoneNumber = inquiry.getPhoneNumber();

    }
}
