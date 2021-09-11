/**
 * 
 */
package com.example.easynotes.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Employee;
import com.example.easynotes.repository.EmployeeRepository;

/**
 * @author Electem2
 *
 */
@RestController
@RequestMapping("/Emapi")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/Employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@PostMapping("/Employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@GetMapping("/Employees/{id}")
	public Employee getEmployeeById(@PathVariable(value = "id") Long employeeid) {
		return employeeRepository.findById(employeeid)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeid));
		
	}

	@PutMapping("/Employees/{id}")
	public Employee updateEmployee(@PathVariable(value = "id") Long employeeid,
			@Valid @RequestBody Employee employeeDetails) {

		Employee employee = employeeRepository.findById(employeeid)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeid));

		employee.setEname(employeeDetails.getEname());
		employee.setErole(employeeDetails.getErole());
		employee.setSalary(employeeDetails.getSalary());
		Employee updatedEmployee = employeeRepository.save(employee);
		return updatedEmployee;

	}

	@DeleteMapping("/Employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Long employeeid) {
		Employee employee = employeeRepository.findById(employeeid)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeid));

		employeeRepository.delete(employee);

    		return ResponseEntity.ok().build();
	}

}
