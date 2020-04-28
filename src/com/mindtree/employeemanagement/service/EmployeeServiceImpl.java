package com.mindtree.employeemanagement.service;

import java.util.List;

import com.mindtree.employeemanagement.dao.EmployeeDaoImpl;
import com.mindtree.employeemanagement.dao.IEmployeeDao;
import com.mindtree.employeemanagement.entity.Employee;
import com.mindtree.employeemanagement.exception.customs.EmployeeDaoException;
import com.mindtree.employeemanagement.exception.customs.EmployeeServiceException;

public class EmployeeServiceImpl implements IEmployeeService {

	@Override
	public String addEmployee(Employee emp) throws EmployeeServiceException {
		IEmployeeDao dao=new EmployeeDaoImpl();
		try {
			String msg=dao.addEmployee(emp);
			return msg;
			}
			catch (EmployeeDaoException e) {
				throw new EmployeeServiceException();
			}
		
	}

	@Override
	public List<Employee> getEmployee() throws EmployeeServiceException {
		IEmployeeDao dao=new EmployeeDaoImpl();
		try {
			List<Employee> empList=dao.getEmployee();
			return empList;
		} catch (EmployeeDaoException e) {
			throw new EmployeeServiceException();
		}
		
	}

	@Override
	public String updateDetails(int id, String name) throws EmployeeServiceException {
		IEmployeeDao dao=new EmployeeDaoImpl();
		try {
			String msg=dao.updateDetails(id,name);
			return msg;
			}
			catch (EmployeeDaoException e) {
				throw new EmployeeServiceException();
			}
		
	}

	@Override
	public String deleteDetails(int id) throws EmployeeServiceException {
		IEmployeeDao dao=new EmployeeDaoImpl();
		try {
			String msg=dao.deleteDetails(id);
			return msg;
			}
			catch (EmployeeDaoException e) {
				throw new EmployeeServiceException(e);
			}
	}
	}
