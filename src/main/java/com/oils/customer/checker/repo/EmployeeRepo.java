package com.oils.customer.checker.repo;


import com.oils.customer.checker.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepo extends JpaRepository<Employees, Long > {

    public Employees findByPhoneNumber(Long phoneNumber);
}
