package com.manju.service;

import java.util.List;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.manju.entity.Customer;
import com.manju.exception.ResourceNotFoundException;

@Service
public interface CustomerService {

	Customer addCustomer(@Valid Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomer(Integer customerId) throws ResourceNotFoundException;

	Customer deleteCustomer(Integer customerId) throws ResourceNotFoundException;

}
