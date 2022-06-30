package com.employee.payslip.service;

import com.employee.payslip.model.Employee;
import com.employee.payslip.model.EmployeePayslip;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * •	pay period = Month of March (01 March to 31 March)
 * •	gross income = 60,050 / 12 = 5,004.16666667 (round down) = 5,004
 * •	income tax = (3,572 + (60,050 - 37,000) x 0.325) / 12 = 921.9375 (round up) = 922
 * •	net income = 5,004 - 922 = 4,082
 * •	super = 5,004 x 9% = 450.36 (round down) = 450
 */
@Service
public class payCal {
    public List<EmployeePayslip> processEmployeePayslip(List<Employee> employees){
        List<EmployeePayslip> employeePayslips=new ArrayList<>();
        employees.forEach(employee -> {
             EmployeePayslip employeePayslip=calculate(employee);
             employeePayslips.add(employeePayslip);
        });
        return employeePayslips;
    }

    private EmployeePayslip calculate(Employee employee) {
        EmployeePayslip employeePayslip=new EmployeePayslip();
        Employee  employee1=HelpEmployee(employee);
        //employee data
        employeePayslip.setEmployee(employee1);

        double tax=0,annual_salary;
        Integer taxMin,over;
        annual_salary= employee.getAnnualSalary();//add the salary
        if(annual_salary<=18200)
            tax=0;
        else if(annual_salary<=37000) {
            taxMin = 0;
            tax = 0.19;
            over=18201;
         //   Integer super_rate=employee.getSuperRate(); // super rate
            Long gross_Income= (Math.round(annual_salary/12));
            Long income_tax=(Math.round(taxMin+(annual_salary-over)*tax)/12);
            Long net_Income= gross_Income-income_tax;
            Long super1= Long.valueOf((Math.round(gross_Income*employee.getSuperRate())));
            employeePayslip.setGrossIncome(Math.toIntExact(gross_Income));
            employeePayslip.setIncomeTax(Math.toIntExact(income_tax));
            employeePayslip.setNetIncome(Math.toIntExact(net_Income));
            employeePayslip.setSuperannuation(Math.toIntExact(super1));
        }
        else if(annual_salary<=87000) {
            taxMin = 3572;
            tax = 0.325;
            over=37000;

            //>=50 CENTS TO NEXT 1$
            Long gross_Income= (Math.round(annual_salary/12));
            Long income_tax=(Math.round(taxMin+(annual_salary-over)*tax)/12);
            Long net_Income= gross_Income-income_tax;
            Long super1= Long.valueOf((Math.round(gross_Income*employee.getSuperRate())));
            employeePayslip.setGrossIncome(Math.toIntExact(gross_Income));
            employeePayslip.setIncomeTax(Math.toIntExact(income_tax));
            employeePayslip.setNetIncome(Math.toIntExact(net_Income));
            employeePayslip.setSuperannuation(Math.toIntExact(super1));
        }
        else if(annual_salary<=180000) {
            taxMin = 19822;
            tax = 0.37;
            over=87000;

            Long gross_Income= (Math.round(annual_salary/12));
            Long income_tax=(Math.round(taxMin+(annual_salary-over)*tax)/12);
            Long net_Income= gross_Income-income_tax;
            Long super1= Long.valueOf((Math.round(gross_Income*employee.getSuperRate())));
            employeePayslip.setGrossIncome(Math.toIntExact(gross_Income));
            employeePayslip.setIncomeTax(Math.toIntExact(income_tax));
            employeePayslip.setNetIncome(Math.toIntExact(net_Income));
            employeePayslip.setSuperannuation(Math.toIntExact(super1));
        }
        else {
            taxMin = 54232;
            tax = 0.45;
            over=180000;

            Long gross_Income= (Math.round(annual_salary/12));
            Long income_tax=(Math.round(taxMin+(annual_salary-over)*tax)/12);
            Long net_Income= gross_Income-income_tax;
            Long super1= Long.valueOf((Math.round(gross_Income*employee.getSuperRate())));
            employeePayslip.setGrossIncome(Math.toIntExact(gross_Income));
            employeePayslip.setIncomeTax(Math.toIntExact(income_tax));
            employeePayslip.setNetIncome(Math.toIntExact(net_Income));
            employeePayslip.setSuperannuation(Math.toIntExact(super1));
        }
        //date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        YearMonth ym = YearMonth.of( calendar.get(Calendar.YEAR), employee.getPaymentMonth());
        String Month = ym.atDay(1).getMonth().name();
        int endOfMonthDate   = ym.atEndOfMonth().lengthOfMonth();
        String endMonth = ym.atEndOfMonth().getMonth().name();
        String FromDate=1+" "+ Month;
        String ToDate=endOfMonthDate+" "+ Month;
        employeePayslip.setFromDate(FromDate);
        employeePayslip.setToDate(ToDate);
        return employeePayslip;
    }
    private Employee HelpEmployee(Employee employee) {
        Employee employee1=new Employee();
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setAnnualSalary(employee.getAnnualSalary());
        employee1.setPaymentMonth(employee.getPaymentMonth());
        employee1.setSuperRate(employee.getSuperRate());
        return employee1;
    }


}
