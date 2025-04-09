package com.oils.customer.checker.dto.responseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesResDto {

    private String name;
    private String role;
    private Long phoneNumber;
    private String email;
}
