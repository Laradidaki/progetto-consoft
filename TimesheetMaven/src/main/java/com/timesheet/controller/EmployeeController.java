package com.timesheet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.timesheet.dao.EmployeeDao;
import com.timesheet.entity.Employee;
import com.timesheet.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	//need to inject the emplyee service
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public String listEmployee(Model theModel) {
		
		//get employees from service
		List<Employee> employees= employeeService.getEmployees();
		
		
		//add the customers to the model
		theModel.addAttribute("employees", employees);
		
		return "list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		Employee theEmployee= new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		return "employee-form";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee")Employee theEmployee) {
		
		//save the employee using the service
		employeeService.saveEmployee(theEmployee);
		
		return "redirect:/employee/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId")int theId,
									Model theModel) {
		
		//get the employee from service
		Employee theEmployee=employeeService.getEmployee(theId);
		
		//set employee as a model attribute to pre-polate the form
		theModel.addAttribute("employee", theEmployee);
		
		//send over to the form
		return "employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId")int theId,
								 Model theModel) {
		
		//delete the employee
		employeeService.deleteEmployee(theId);
		
		return "redirect:/employee/list";
	}

    @GetMapping("/search")
    public String searchEmployees(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search customers from the service
        List<Employee> theEmployees = employeeService.searchEmployees(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";        
    }
}
