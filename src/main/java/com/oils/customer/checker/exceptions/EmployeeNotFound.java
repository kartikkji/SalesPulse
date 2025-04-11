package com.oils.customer.checker.exceptions;

public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound(String message) {
        super(message);
    }
}
