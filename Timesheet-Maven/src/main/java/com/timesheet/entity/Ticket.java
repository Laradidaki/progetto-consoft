package com.timesheet.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer idTicket ;
	@Column(name="client")
	private String client;
	@Column(name="start_date")
	private Date startDate;
	@Column(name="release_date")
	private Date releaseDate;
	@Column(name="estimate")
	private Double estimate;
	@Column(name="description")
	private String description;
	@Column(name="tot_working_hours")
	private Double totWorkingHours;
	@Column(name="production_order")
	private String productionOrder;
	@Column(name="note")
	private String note;
	@Column(name="priority")
	private String priority;
	@Column(name="ticket_status")
	private String ticketStatus;
	@Column(name="ticket_source")
	private String ticketSource;
	@Column(name="ticket_type")
	private String ticketType;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name="manager_id")
	private Manager manager;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name="ticket_employee", joinColumns = @JoinColumn(name="ticket_id"),
			   inverseJoinColumns = @JoinColumn(name="employee_id"))
	private List<Employee>employees;
	
	public Ticket() {
	
	}

	public Ticket(String client, Date startDate, Date releaseDate, Double estimate, String description,
			Double totWorkingHours, String productionOrder, String note, String priority, String ticketStatus,
			String ticketSource, String ticketType) {
		super();
		this.client = client;
		this.startDate = startDate;
		this.releaseDate = releaseDate;
		this.estimate = estimate;
		this.description = description;
		this.totWorkingHours = totWorkingHours;
		this.productionOrder = productionOrder;
		this.note = note;
		this.priority = priority;
		this.ticketStatus = ticketStatus;
		this.ticketSource = ticketSource;
		this.ticketType = ticketType;
	}

	public Integer getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Double getEstimate() {
		return estimate;
	}

	public void setEstimate(Double estimate) {
		this.estimate = estimate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getTotWorkingHours() {
		return totWorkingHours;
	}

	public void setTotWorkingHours(Double totWorkingHours) {
		this.totWorkingHours = totWorkingHours;
	}

	public String getProductionOrder() {
		return productionOrder;
	}

	public void setProductionOrder(String productionOrder) {
		this.productionOrder = productionOrder;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getTicketSource() {
		return ticketSource;
	}

	public void setTicketSource(String ticketSource) {
		this.ticketSource = ticketSource;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	//add a convenience method
	public void addEmployee(Employee tempEmployee) {
		
		if(employees == null) {
			employees=new ArrayList<Employee>();
		}
		employees.add(tempEmployee);
	}
	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", client=" + client + ", startDate=" + startDate + ", releaseDate="
				+ releaseDate + ", estimate=" + estimate + ", description=" + description + ", totWorkingHours="
				+ totWorkingHours + ", productionOrder=" + productionOrder + ", note=" + note + ", priority=" + priority
				+ ", ticketStatus=" + ticketStatus + ", ticketSource=" + ticketSource + ", ticketType=" + ticketType
				+ "]";
	}

	
	
	
	
	
}
