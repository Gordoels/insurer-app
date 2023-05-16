package com.insurer.app.cardriver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurer.app.cardriver.exception.CarDriverNotFoundException;
import com.insurer.app.cardriver.model.CarDriver;
import com.insurer.app.cardriver.repository.CarDriverRepository;

@Service
public class CarDriverService {

	@Autowired
	private CarDriverRepository carDriverRepository;

	public List<CarDriver> getAllCarDrivers() {
		return carDriverRepository.findAll();
	}

	public CarDriver getCarDriverById(Long id) {
		return carDriverRepository.findById(id)
				.orElseThrow(() -> new CarDriverNotFoundException("exception.carDriverNotFoundException"));
	}

	public CarDriver createCarDriver(CarDriver carDriver) {
		return carDriverRepository.save(carDriver);
	}

	public CarDriver updateCarDriver(Long id, CarDriver updatedCarDriver) {
		
		CarDriver existingCarDriver = carDriverRepository.findById(id)
				.orElseThrow(() -> new CarDriverNotFoundException("exception.carDriverNotFoundException"));

		updatedCarDriver = carDriverRepository.save(existingCarDriver);
		return updatedCarDriver;
	}

	public void deleteCarDriver(Long id) {
		carDriverRepository.deleteById(id);
	}
}
