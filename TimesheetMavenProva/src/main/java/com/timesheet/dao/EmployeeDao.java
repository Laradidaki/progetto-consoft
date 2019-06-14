package com.timesheet.dao;

import java.util.List;

import com.timesheet.entity.Employee;

public interface EmployeeDao {

	public List<Employee> getEmployees();

	public void saveEmployee(Employee theEmployee);

	public Employee getEmployee(int theId);

	public void deleteEmployee(int theId);

	public List<Employee> searchEmployees(String theSearchName);
}
