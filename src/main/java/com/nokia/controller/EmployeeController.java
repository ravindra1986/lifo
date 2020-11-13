/**
 * 
 */
package com.nokia.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nokia.exception.ResourceNotFoundException;
import com.nokia.model.Employee;
import com.nokia.service.EmployeeService;

/**
 * @author ravindra
 *
 */
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@DeleteMapping("/employee")
    public Map <String, Boolean> pop()  throws ResourceNotFoundException {
		boolean delete=employeeService.pop();
        if(delete) {
        Map <String, Boolean> response = new HashMap <> ();
        response.put("deleted", Boolean.TRUE);
        return response;
        }
        else {
        	throw new ResourceNotFoundException("Employee data is not available into table");
        }
    }
	@PostMapping("/employee")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.push(employee);
    }
	
	 @GetMapping("/employee")
	    public List < Employee > getAllEmployees() {
	        return employeeService.getAllEmployees();
	    }
}
