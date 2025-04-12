package com.oils.customer.checker.contoller;


import com.oils.customer.checker.dto.requestDto.EmployeesReqDto;
import com.oils.customer.checker.dto.responseDto.EmployeesResDto;
import com.oils.customer.checker.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/auto-pickup")
public class EmployeesController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get")
    public ResponseEntity<EmployeesResDto> getByID(@RequestParam Long Id){
        return employeeService.fndById(Id);
    }

}
