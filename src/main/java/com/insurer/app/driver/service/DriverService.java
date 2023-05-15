package com.insurer.app.driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurer.app.driver.exception.DriverNotFoundException;
import com.insurer.app.driver.model.Driver;
import com.insurer.app.driver.repository.DriverRepository;

@Service
public class DriverService {
	
	@Autowired
    private DriverRepository driverRepository;

    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver getDriverById(Long id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new DriverNotFoundException());
    }
}

