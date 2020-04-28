package com.mindtree.employeemanagement.dao;

import java.util.List;

import com.mindtree.employeemanagement.entity.Employee;
import com.mindtree.employeemanagement.exception.customs.EmployeeDaoException;

public interface IEmployeeDao {

	String addEmployee(Employee emp) throws EmployeeDaoException;
	List<Employee> getEmployee() throws EmployeeDaoException;
	String updateDetails(int id, String name) throws EmployeeDaoException;
	String deleteDetails(int id) throws EmployeeDaoException;

}
