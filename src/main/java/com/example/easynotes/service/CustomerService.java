/**
 * 
 */
package com.example.easynotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Customer;
import com.example.easynotes.repository.CustomerRepository;

/**
 * @author Electem2
 *
 */
@Service
public class CustomerService {
	@Autowired
	CustomerRepository cutomerrepository;

	public Customer saveCustomer(Customer customer) {
		return cutomerrepository.save(customer);

	}

	public Customer updateDateCustomer(Customer customerDetails, Long customerId) {

		Customer customer1 = cutomerrepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
		customer1.setName(customerDetails.getName());
		customer1.setCity(customerDetails.getCity());
		customer1.setCustomerKey(customerDetails.getCustomerKey());
		customer1.setAddress(customerDetails.getAddress());
		cutomerrepository.save(customer1);
		return customerDetails;

	}

	public Customer fetchById(Long customerid) {
	
		return cutomerrepository.findById(customerid)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerid));
	}

	public List<Customer> fetchallCustomers() {
		return cutomerrepository.findAll();

	}

}
