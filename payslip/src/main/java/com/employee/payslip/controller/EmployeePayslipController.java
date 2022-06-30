package com.employee.payslip.controller;

import com.employee.payslip.model.Employee;
import com.employee.payslip.model.EmployeePayslip;
import com.employee.payslip.service.payCal;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeePayslipController {

private final com.employee.payslip.service.payCal payCal;

@GetMapping("getMonthlyPayslip")
    public  List<EmployeePayslip> GetMonthlyPayslip(@RequestBody List<Employee> employeeList){

                List<EmployeePayslip> employeePayslips= payCal.processEmployeePayslip(employeeList);
                return employeePayslips;
    }
}
