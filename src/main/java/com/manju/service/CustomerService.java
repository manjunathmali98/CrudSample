package com.manju.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.manju.entity.Customer;
import com.manju.exception.ResourceNotFoundException;

@Service
public interface CustomerService {

	Customer addCustomer(@Valid Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomer(Long customerId) throws ResourceNotFoundException;

}
