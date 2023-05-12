package com.insurer.app.driver.service;

import org.springframework.stereotype.Service;

import com.insurer.app.driver.model.Driver;
import com.insurer.app.driver.repository.DriverRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DriverService {
    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver getDriverById(Long id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Driver not found with ID: " + id));
    }
}

