package com.insurer.app.claim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurer.app.car.exception.CarNotFoundException;
import com.insurer.app.car.model.Car;
import com.insurer.app.car.repository.CarRepository;
import com.insurer.app.claim.exception.ClaimNotFoundException;
import com.insurer.app.claim.model.Claim;
import com.insurer.app.claim.repository.ClaimRepository;
import com.insurer.app.driver.exception.DriverNotFoundException;
import com.insurer.app.driver.model.Driver;
import com.insurer.app.driver.repository.DriverRepository;

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
				.orElseThrow(() -> new CarNotFoundException());

		Driver driver = driverRepository.findById(claim.getDriver().getDriverId()).orElseThrow(
				() -> new DriverNotFoundException());

		Claim newClaim = new Claim();
		newClaim.setCar(car);
		newClaim.setDriver(driver);
		newClaim.setEventDate(claim.getEventDate());

		return claimRepository.save(newClaim);
	}

	public Claim getClaimById(Long id) {
		return claimRepository.findById(id)
				.orElseThrow(() -> new ClaimNotFoundException());
	}

	public Claim updateClaim(Long id, Claim claim) {
		Claim newClaim = claimRepository.findById(id)
				.orElseThrow(() -> new ClaimNotFoundException());

		Car car = carRepository.findById(claim.getCar().getCarId())
				.orElseThrow(() -> new CarNotFoundException());

		Driver driver = driverRepository.findById(claim.getDriver().getDriverId()).orElseThrow(
				() -> new DriverNotFoundException());

		newClaim.setCar(car);
		newClaim.setDriver(driver);
		newClaim.setEventDate(claim.getEventDate());

		return claimRepository.save(newClaim);
	}
}
