//package com.employee.payslip.util;
//
//import com.employee.payslip.model.EmployeePayslip;
//import lombok.Data;
//import org.springframework.http.HttpStatus;
//
//import java.util.List;
//
//@Data
//public class Result {
//    private int code;
//    private String msg;
//    private List<EmployeePayslip> employeePayslips;
//    private static Result of(int code, String msg, EmployeePayslip data) {
//        Result resultItem = new Result();
//        resultItem.setCode(code);
//        resultItem.setMsg(msg);
//        resultItem.setEmployeePayslips(data);
//        return resultItem;
//    }
//
//    public static Result success(EmployeePayslip item) {
//        return of(HttpStatus.OK.value(), "success", employeePayslips);
//    }
//
//    public static Result failure(EmployeePayslip item) {
//        return of(HttpStatus.BAD_REQUEST.value(), "Request parameter error", employeePayslips);
//    }
//
//}
