package com.oils.customer.checker.repo;

import com.oils.customer.checker.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepo extends JpaRepository<Inquiry, Long > {

    public Inquiry findByPhoneNumber(Long phoneNumber);
}
