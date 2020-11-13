/**
 * 
 */
package com.nokia.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nokia.model.Employee;
import com.nokia.repository.EmployeeRepository;

/**
 * @author ravindra
 *
 */
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee push(Employee employee) {
		return employeeRepository.save(employee);
	}

	public boolean pop() {
		List<Employee> empList = employeeRepository.findAll();
		if (empList != null && empList.size() > 0) {
			List<Employee> sortedEmpList = empList.stream()
					.sorted(Comparator.comparing(Employee::getId).reversed()).collect(Collectors.toList());
			Employee emp = sortedEmpList.get(0);
			employeeRepository.deleteById(emp.getId());
			return true;
		} else {
			return false;
		}
	}
public List<Employee> getAllEmployees(){
	return employeeRepository.findAll();
}
}
