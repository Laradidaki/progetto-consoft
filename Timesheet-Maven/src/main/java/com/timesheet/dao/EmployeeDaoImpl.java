package com.timesheet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.timesheet.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Employee> getEmployees() {

		//get the current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		
		//create a query sort by last name
		Query<Employee>theQuery=currentSession.createQuery("from Employee order by lastName ",
															Employee.class);
		
		//execute query and get result list
		List<Employee>employees=theQuery.getResultList();
		
		//return the results
		return employees;
	
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		
		//get current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		
		//save/update the employee
		currentSession.saveOrUpdate(theEmployee);
		
	}

	@Override
	public Employee getEmployee(int theId) {

		//get the current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		
		//retrieve from database using the primary key
		Employee theEmployee=currentSession.get(Employee.class, theId);
		
		return theEmployee;
	}

	@Override
	public void deleteEmployee(int theId) {
		
		Session currentSession= sessionFactory.getCurrentSession();
		
		//delete the employee with primary key
		Query theQuery= currentSession.createQuery("delete from Employee where idEmployee=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Employee> searchEmployees(String theSearchName) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Employee where lower(firstName) like :theName or lower(lastName) like :theName", Employee.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all employees
            theQuery =currentSession.createQuery("from Employee", Employee.class);            
        }
        
        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();
                
        // return the results        
        return employees;
        
    }
	}


