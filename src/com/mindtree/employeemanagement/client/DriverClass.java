package com.mindtree.employeemanagement.client;

import java.util.List;
import java.util.Scanner;

import com.mindtree.employeemanagement.entity.Employee;
import com.mindtree.employeemanagement.exception.EmployeeAppException;
import com.mindtree.employeemanagement.exception.customs.EmployeeServiceException;
import com.mindtree.employeemanagement.service.EmployeeServiceImpl;
import com.mindtree.employeemanagement.service.IEmployeeService;

public class DriverClass {

	public static void main(String[] args) {
		IEmployeeService ser=new EmployeeServiceImpl();
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		do
		{
			System.out.println("1.Add employees");
			System.out.println("2.Retrive the employee data");
			 System.out.println("3.update employee data");
			 System.out.println("4.delete the employee data");
			 System.out.println("enter your choice");
			 int choice=sc.nextInt();
			 switch(choice)
			 {
			 case 1:
				 System.out.println("enter the employee id");
				 int id=sc.nextInt();
				 sc.nextLine();
				 System.out.println("enter the employee name");
				 String name=sc.nextLine();
				 System.out.println("enter the employee salary");
				 double salary=sc.nextDouble();
				 Employee emp=new Employee(id,name,salary);
				 try {
					String msg=ser.addEmployee(emp);
					System.out.println(msg);
				} catch (EmployeeServiceException e) {
					System.out.println("something went wrong");
					
				}
				 break;
			 case 2:
				 try
				 {
					 List<Employee> empList=ser.getEmployee();
					 for(Employee e:empList)
					 {
						 System.out.println(e.toString());
					 }
				 }
				 catch(EmployeeServiceException e)
				 {
					 System.out.println("something went wrong");
				 }
				 break;
			 case 3:
				 System.out.println("enter the id to update");
				 id=sc.nextInt();
				 sc.nextLine();
				 System.out.println("enter the name to be updated");
				 name=sc.nextLine();
				 try {
					String mess=ser.updateDetails(id,name);
					System.out.println(mess);
				} catch (EmployeeAppException e) {
					System.out.println(e.getMessage());
				}
				 List<Employee> empList = null;
				try {
					empList = ser.getEmployee();
				} catch (EmployeeServiceException e1) {
					System.out.println("something went wrong");
				}
				 for(Employee e:empList)
				 {
					 System.out.println(e.toString());
				 }
				 break;
			 case 4:
				 System.out.println("enter the id to delete");
				 id=sc.nextInt();
				 try {
						String mess=ser.deleteDetails(id);
						System.out.println(mess);
					} catch (EmployeeAppException e) {
						e.printStackTrace();
						System.out.println(e.getMessage());
					}
					 List<Employee> empList1 = null;
					try {
						empList1 = ser.getEmployee();
					} catch (EmployeeServiceException e1) {
						System.out.println("something went wrong");
					}
					 for(Employee e:empList1)
					 {
						 System.out.println(e.toString());
					 }
				 
				 break;
				 
				 default:
					 break;
				 
				 
			 }
			 
		}
		while(flag);
		
		

	}

}
