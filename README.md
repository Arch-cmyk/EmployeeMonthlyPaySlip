# EmployeeMonthlyPaySlip

When supplied with employee details: first name, last name, 

annual salary (positive integer) and super rate (0% - 50% inclusive), payment start date,

the program should generate pay slip information which includes name, pay period, gross income, income tax,
net income and super. 

Step1: When we run the postman's GET method http://localhost:8091/getMonthlyPayslip

we get the desired output based on the GET mapping annotation;

 Spring had only @RequestMapping annotation for mapping all the incoming HTTP 
 request URLs to the corresponding controller methods.
 
 This Trigger the class where the business logic is being processed and finally the desired output is being displayed.
 
 Docker Image as also been included in this file.
 
 Deployment of this APP using cloud services will be done soon.
 

Postman based tests:
Sample data and its output;

![Screenshot 2022-06-30 232125](https://user-images.githubusercontent.com/53118174/176687984-c8346646-853e-4d71-a378-c5265797e733.png)

Sample data of ryan and its output as per the format

![Screenshot 2022-06-30 232146](https://user-images.githubusercontent.com/53118174/176688334-dfef9115-0de4-43b8-a831-a7a2030dbcbd.png)
