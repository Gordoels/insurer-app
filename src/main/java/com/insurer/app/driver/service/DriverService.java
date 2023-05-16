package com.insurer.app.driver.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurer.app.driver.exception.DriverNotFoundException;
import com.insurer.app.driver.exception.DriverUnderAgeException;
import com.insurer.app.driver.model.Driver;
import com.insurer.app.driver.repository.DriverRepository;

@Service
public class DriverService {

	@Autowired
	private DriverRepository driverRepository;

	public Driver createDriver(Driver driver) {
		LocalDate presentDay = LocalDate.now();
		int age = Period.between(driver.getBirthdate(), presentDay).getYears();
		
		Optional.of(age).filter(yo -> yo < 18).ifPresent(yo -> {
			throw new DriverUnderAgeException();
		});

		return driverRepository.save(driver);
	}

	public Driver getDriverById(Long id) {
		return driverRepository.findById(id).orElseThrow(() -> new DriverNotFoundException());
	}
}
