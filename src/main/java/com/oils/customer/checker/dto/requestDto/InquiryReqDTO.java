package com.oils.customer.checker.dto.requestDto;

import com.oils.customer.checker.entity.Employees;
import com.oils.customer.checker.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InquiryReqDTO {

    private Long phoneNumber;
    private String name;
    private String employeeEmail;
    private State state;

}
