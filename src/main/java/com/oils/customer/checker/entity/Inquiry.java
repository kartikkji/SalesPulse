package com.oils.customer.checker.entity;


import com.oils.customer.checker.dto.responseDto.InquiryResDTO;
import com.oils.customer.checker.enums.State;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Inquiry")
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long phoneNumber;
    private String name;
    private LocalDate date;
    private State state;


    @ManyToOne()
    @JoinColumn(name = "employee_id")
    private Employees employees;


    public Inquiry(InquiryResDTO inquiryResDTO) {

       this.date = LocalDate.now();
       this.state = inquiryResDTO.getState();
       this.phoneNumber = inquiryResDTO.getPhoneNumber();
       this.name = inquiryResDTO.getName();

    }

}
