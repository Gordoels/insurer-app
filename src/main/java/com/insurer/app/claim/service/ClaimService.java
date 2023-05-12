package com.insurer.app.claim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurer.app.car.model.Car;
import com.insurer.app.car.repository.CarRepository;
import com.insurer.app.claim.model.Claim;
import com.insurer.app.claim.repository.ClaimRepository;
import com.insurer.app.driver.model.Driver;
import com.insurer.app.driver.repository.DriverRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClaimService {
	
	@Autowired
	private ClaimRepository claimRepository;
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private DriverRepository driverRepository;

	public Claim createClaim(Claim claim) {
		Car car = carRepository.findById(claim.getCar().getCarId())
				.orElseThrow(() -> new EntityNotFoundException("Car not found with id: " + claim.getCar().getCarId()));

		Driver driver = driverRepository.findById(claim.getDriver().getDriverId()).orElseThrow(
				() -> new EntityNotFoundException("Driver not found with id: " + claim.getDriver().getDriverId()));

		Claim newClaim = new Claim();
		newClaim.setCar(car);
		newClaim.setDriver(driver);
		newClaim.setEventDate(claim.getEventDate());

		return claimRepository.save(newClaim);
	}

	public Claim getClaimById(Long id) {
		return claimRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Claim not found with id: " + id));
	}

	public Claim updateClaim(Long id, Claim claim) {
		Claim newClaim = claimRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Claim not found with id: " + id));

		Car car = carRepository.findById(claim.getCar().getCarId())
				.orElseThrow(() -> new EntityNotFoundException("Car not found with id: " + claim.getCar().getCarId()));

		Driver driver = driverRepository.findById(claim.getDriver().getDriverId()).orElseThrow(
				() -> new EntityNotFoundException("Driver not found with id: " + claim.getDriver().getDriverId()));

		newClaim.setCar(car);
		newClaim.setDriver(driver);
		newClaim.setEventDate(claim.getEventDate());

		return claimRepository.save(newClaim);
	}
}
