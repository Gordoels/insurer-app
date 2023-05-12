package com.insurer.app.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurer.app.driver.model.Driver;


public interface DriverRepository extends JpaRepository<Driver, Long> {
}

