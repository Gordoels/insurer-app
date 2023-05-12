package com.insurer.app.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurer.app.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
