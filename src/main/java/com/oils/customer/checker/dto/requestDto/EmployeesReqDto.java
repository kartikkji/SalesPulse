package com.oils.customer.checker.dto.requestDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesReqDto {

   private String name;
   private String role;
   private Long phoneNumber;
   private String email;

}
