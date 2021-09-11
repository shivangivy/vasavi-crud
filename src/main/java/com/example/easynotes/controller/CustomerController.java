/**
 * 
 */
package com.example.easynotes.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.model.Customer;
import com.example.easynotes.service.CustomerService;

/**
 * @author Electem2s
 * @param <Customer>
 *
 */
@RestController
@RequestMapping("/rest/controller")
public class CustomerController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	CustomerService cutomerservice;

	@PostMapping("/customer")
	public Customer createNote(@Valid @RequestBody Customer customer) {
		log.info("Start of CustomerController : createNote ");
		return cutomerservice.saveCustomer(customer);
		
	}

	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable(value = "id") Long customerid) {
		return cutomerservice.fetchById(customerid);
	}

	@PutMapping("/Customers/{id}")
	public Customer UpdateCustomer(@PathVariable(value = "id") Long customerId,
			@Valid @RequestBody Customer customerdetails) {

		Customer customer = cutomerservice.updateDateCustomer(customerdetails, customerId);
		return customer;  
	}

	@GetMapping("/Customers")
	public List<Customer> getAllCustomers() {
		return cutomerservice.fetchallCustomers();

	}

}
