package com.insurer.app.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurer.app.customer.exception.CustomerNotFoundException;
import com.insurer.app.customer.model.Customer;
import com.insurer.app.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
    private CustomerRepository customerRepository;
    
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("exception.customerNotFoundException"));
    }
    
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
}

