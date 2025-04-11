package com.oils.customer.checker.exceptions;

public class PhoneNumberAlreadyRegister extends RuntimeException {
    public PhoneNumberAlreadyRegister(String message) {
        super(message);
    }
}
