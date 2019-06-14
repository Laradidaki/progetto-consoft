package com.timesheet.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

	
	@Entity
	@Table(name="manager")
	public class Manager {
		 
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private Integer idManager;
		@Column(name="first_name")
		private String firstName;
		@Column(name="last_name")
		private String lastName;
		
		@OneToMany(mappedBy = "manager",
		           cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
		private List<Ticket>tickets;

		@OneToMany(mappedBy = "manager",
		           cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
		private List<Employee>employees;
		
		//generate constructors
		public Manager() {
			
		}

		public Manager(String firstName, String lastName) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
		}

		//generate getter/setter methods
		public Integer getIdManager() {
			return idManager;
		}

		public void setIdManager(Integer idManager) {
			this.idManager = idManager;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		
		public List<Ticket> getTickets() {
			return tickets;
		}

		public void setTickets(List<Ticket> tickets) {
			this.tickets = tickets;
		}

		public List<Employee> getEmployees() {
			return employees;
		}

		public void setEmployees(List<Employee> employees) {
			this.employees = employees;
		}

		//generate toString() method
		@Override
		public String toString() {
			return "Manager [id=" + idManager + ", firstName=" + firstName + ", lastName=" + lastName + "]";
		}

		public void addTicket(Ticket tempTicket) {
			if(tickets == null) {
				tickets= new ArrayList<Ticket>();
			}
			
			tickets.add(tempTicket);
			tempTicket.setManager(this);
		}
		
		public void addEmployee(Employee tempEmployee) {
			if(employees == null) {
				employees= new ArrayList<Employee>();
			}
			
			employees.add(tempEmployee);
			tempEmployee.setManager(this);
		}
		
		
}
