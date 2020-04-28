package com.mindtree.employeemanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.employeemanagement.entity.Employee;
import com.mindtree.employeemanagement.exception.customs.EmployeeDaoException;
import com.mindtree.employeemanagement.utility.DBConnection;

public class EmployeeDaoImpl implements IEmployeeDao {
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static Connection con = null;

	@Override
	public String addEmployee(Employee emp) throws EmployeeDaoException {
		con = DBConnection.getConnection();
		try {
			ps = con.prepareStatement("insert into employee values(?,?,?)");
			ps.setInt(1, emp.getEmployeeId());
			ps.setString(2, emp.getEmployeeName());
			ps.setDouble(3, emp.getSalary());
			ps.execute();
			con.close();
		} catch (Exception e) {
			throw new EmployeeDaoException();
		}
		return "Employee added";
	}

	@Override
	public List<Employee> getEmployee() throws EmployeeDaoException {
		List<Employee> empList = new ArrayList<>();
		con = DBConnection.getConnection();
		try {
			ps = con.prepareStatement("select * from employee");
			rs = ps.executeQuery();
			while (rs.next()) {
				empList.add(new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
			}
			return empList;
		} catch (SQLException e) {
			throw new EmployeeDaoException();
		}

	}

	@Override
	public String updateDetails(int id, String name) throws EmployeeDaoException {
		con = DBConnection.getConnection();
		try {
			ps = con.prepareStatement("update employee set employeeName=? where employeeId=?;");
			ps.setString(1, name);
			ps.setInt(2, id);
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			throw new EmployeeDaoException();
		}
		return "Employee updated";

	}

	@Override
	public String deleteDetails(int id) throws EmployeeDaoException {
		con = DBConnection.getConnection();
		try {
			ps = con.prepareStatement("delete from employee where employeeId=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			throw new EmployeeDaoException(e);
		}
		return "Employee record deleted";
	}

}
