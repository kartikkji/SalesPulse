package com.oils.customer.checker.contoller;


import com.oils.customer.checker.dto.requestDto.InquiryReqDTO;
import com.oils.customer.checker.dto.responseDto.InquiryResDTO;
import com.oils.customer.checker.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/inquiry")
public class InquiryController {

    @Autowired
    private InquiryService inquiryService;

    @PostMapping("/add")
    public ResponseEntity<InquiryResDTO> saveNumber(@RequestBody InquiryReqDTO inquiryReqDTO){
        return  inquiryService.saveNumber(inquiryReqDTO);
    }
}
