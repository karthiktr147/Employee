package com.mindtree.employeemanagement.service;

import java.util.List;

import com.mindtree.employeemanagement.entity.Employee;
import com.mindtree.employeemanagement.exception.customs.EmployeeServiceException;

public interface IEmployeeService {
	public String addEmployee(Employee emp) throws EmployeeServiceException;
	
	List<Employee> getEmployee() throws EmployeeServiceException;
	public String updateDetails(int id,String name) throws EmployeeServiceException;

	public String deleteDetails(int id) throws EmployeeServiceException;

}
