package com.insurer.app.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurer.app.driver.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
}

