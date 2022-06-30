package com.employee.payslip.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class EmployeePayslip {
    private Employee employee;
    private String   fromDate;//":"01 February",
    private String   toDate;//":"28 February",
    private Integer grossIncome;//":10000,
    private Integer incomeTax;//":2669,
    private Integer  superannuation;//":1000,
    private Integer  netIncome;//":7331

        }

