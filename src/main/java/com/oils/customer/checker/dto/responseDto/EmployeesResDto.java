package com.oils.customer.checker.dto.responseDto;
import com.oils.customer.checker.entity.Inquiry;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeesResDto {

    private Long id;
    private String name;
    private String role;
    private Long phoneNumber;
    private String email;
    private List<InquiryResDTO> inquiries;
}
