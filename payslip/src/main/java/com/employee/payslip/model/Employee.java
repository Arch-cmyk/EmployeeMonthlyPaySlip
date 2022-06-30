package com.employee.payslip.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class Employee {
    private String firstName;
    private String lastName;
    private Integer annualSalary;
    private Integer paymentMonth;
    private Float superRate;
}
