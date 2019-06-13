package com.timesheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timesheet.dao.EmployeeDao;
import com.timesheet.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {

		employeeDao.saveEmployee(theEmployee);
	}

	@Override
	@Transactional
	public Employee getEmployee(int theId) {
		
		return employeeDao.getEmployee(theId);
		
	}

	@Override
	@Transactional
	public void deleteEmployee(int theId) {

		employeeDao.deleteEmployee(theId);
	}

	@Override
	@Transactional
	public List<Employee> searchEmployees(String theSearchName) {
		return employeeDao.searchEmployees(theSearchName);
	}

}
