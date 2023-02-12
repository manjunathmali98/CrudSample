package com.manju.service.impl;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.manju.entity.Customer;
import com.manju.exception.ResourceNotFoundException;
import com.manju.respository.CustomerRepository;
import com.manju.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(@Valid Customer customer) {

		Customer c = customerRepository.save(customer);

		return c;
	}

	@Override
	public List<Customer> getAllCustomers() {

		List<Customer> customers = customerRepository.findAll();

		return customers;
	}

	@Override
	public Customer getCustomer(Long customerId) throws ResourceNotFoundException {

		Customer c = customerRepository.findById(customerId)
									   .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

		return c;
	}

	@Override
	public Customer deleteCustomer(Long customerId) throws ResourceNotFoundException {
		
		 Customer customer = customerRepository.findById(customerId)
		            						   .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

		 customerRepository.delete(customer);
		 
		 return customer;	    
		
	}

}
