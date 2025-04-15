package com.oils.customer.checker.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Employees")
@Builder
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;
    private String name;
    private Long phoneNumber;
    private String email;
    private String password;


    @OneToMany(mappedBy = "employees" , cascade = CascadeType.ALL)
    @JsonIgnore()
    private List<Inquiry> inquiries;
}
