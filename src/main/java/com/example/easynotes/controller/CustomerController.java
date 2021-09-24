/**
 * 
 */
package com.example.easynotes.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.example.easynotes.model.Customer;
import com.example.easynotes.model.Employee;
import com.example.easynotes.repository.CustomerRepository;
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

	@Autowired
	CustomerRepository cutomerrepository;

	/**
	 * @author Electem2s
	 * @param <Customer>
	 *
	 */
	@PostMapping("/custoddmer")
	public Customer createNote(@Valid @RequestBody Customer customer) {
		log.info("Start of CustomerController : createNote ");
		return cutomerservice.saveCustomer(customer);

	}

	/**
	 * @author Electem2s
	 * @param <Customer>
	 *
	 */

	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable(value = "id") Integer customerid) {
		return cutomerservice.fetchById(customerid);
	}

	/**
	 * @author Electem2s
	 * @param <Customer>
	 *
	 */
	@PutMapping("/Customers/{id}")
	public Customer updateCustomer(@PathVariable(value = "id") Integer customerId,
			@Valid @RequestBody final Customer customerdetails) {
		/**
		 * @author Electem2s
		 * @param <Customer>
		 *
		 */

		Customer customer = cutomerservice.updateDateCustomer(customerdetails, customerId);
		return customer;
	}

	@GetMapping("/Customers")
	public List<Customer> getAllCustomers() {
		return cutomerservice.fetchallCustomers();

	}

	@DeleteMapping("/cust/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Integer employeeid) {
		Customer employee = cutomerrepository.findById(employeeid)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeid));

		cutomerrepository.delete(employee);

    		return ResponseEntity.ok().build();
	}

}
