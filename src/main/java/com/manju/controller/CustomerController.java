package com.manju.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.validation.Valid;

import com.manju.entity.Customer;
import com.manju.exception.ResourceNotFoundException;
import com.manju.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	@PostMapping("/customer")
	public ResponseEntity<Customer>addCustomer(@Valid @RequestBody Customer customer) {
		
		Customer c = customerService.addCustomer(customer);
		
		return ResponseEntity.ok().body(c);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		
		List<Customer> customers = customerService.getAllCustomers();
		return ResponseEntity.ok().body(customers);
	}
	
	@GetMapping("/customers/{id}")
    public ResponseEntity < Customer > getEmployeeById(@PathVariable(value = "id") Long customerId)
    throws ResourceNotFoundException {
        Customer c = customerService.getCustomer(customerId);
           
        return ResponseEntity.ok().body(c);
    }
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value  = "id") Long customerId, @Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
		Customer c = customerService.getCustomer(customerId);

            c.setEmail(customerDetails.getEmail());
            c.setName(customerDetails.getName());
            
            final Customer updatedCustomer = customerService.addCustomer(c);
            return ResponseEntity.ok(updatedCustomer);
	}
}
