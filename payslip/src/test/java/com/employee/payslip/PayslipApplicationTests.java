package com.employee.payslip;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
class PayslipApplicationTests {

	@Test
	void contextLoads() {
		double tax=0,annual_salary;
		Integer taxMin,over;
		annual_salary=60050;//add the salary
		if(annual_salary<=18200)
			tax=0;
		else if(annual_salary<=37000) {
			taxMin = 0;
			tax = 0.19;
			over=18201;
			Integer super_rate=9; // super rate
			Long gross_Income= (Math.round(annual_salary/12));
			Long income_tax=(Math.round(taxMin+(annual_salary-over)*tax)/12);
			Long net_Income= gross_Income-income_tax;
			Long super1= Long.valueOf((Math.round(gross_Income*super_rate)/100));
		}
		else if(annual_salary<=87000) {
			taxMin = 3572;
			tax = 0.325;
			over=37000;
			Integer super_rate=9;	
			//>=50 CENTS TO NEXT 1$	
			Long gross_Income= (Math.round(annual_salary/12));					
			Long income_tax=(Math.round(taxMin+(annual_salary-over)*tax)/12);
			Long net_Income= gross_Income-income_tax;
			Long super1= Long.valueOf((Math.round(gross_Income*super_rate)/100));
		}
		else if(annual_salary<=180000) {
			taxMin = 19822;
			tax = 0.37;
			over=87000;
			Integer super_rate=9;
			Long gross_Income= (Math.round(annual_salary/12));
			Long income_tax=(Math.round(taxMin+(annual_salary-over)*tax)/12);
			Long net_Income= gross_Income-income_tax;
			Long super1= Long.valueOf((Math.round(gross_Income*super_rate)/100));
		}
		else {
			taxMin = 54232;
			tax = 0.45;
			over=180000;
			Integer super_rate=9;
			Long gross_Income= (Math.round(annual_salary/12));
			Long income_tax=(Math.round(taxMin+(annual_salary-over)*tax)/12);
			Long net_Income= gross_Income-income_tax;
			Long super1= Long.valueOf((Math.round(gross_Income*super_rate)/100));
		}
	}
	@Test
	public void date1(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		System.out.println();
		System.out.println();
		YearMonth ym = YearMonth.of( calendar.get(Calendar.YEAR), 12);

		String Month = ym.atDay(1).getMonth().name();
		int endOfMonthDate   = ym.atEndOfMonth().lengthOfMonth();
		String endMonth = ym.atEndOfMonth().getMonth().name();
		System.out.println();
		System.out.println(  1+" "+ Month);
		System.out.println(endOfMonthDate+" "+ Month);

	}

}
