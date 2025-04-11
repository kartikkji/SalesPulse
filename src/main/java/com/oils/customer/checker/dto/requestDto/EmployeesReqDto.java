package com.oils.customer.checker.dto.requestDto;


import com.oils.customer.checker.entity.Inquiry;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class EmployeesReqDto {

   private String name;
   private String role;
   private Long phoneNumber;
   private String email;


}
