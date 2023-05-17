package com.insurer.app.cardriver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurer.app.car.exception.CarNotFoundException;
import com.insurer.app.car.model.Car;
import com.insurer.app.car.repository.CarRepository;
import com.insurer.app.cardriver.exception.CarDriverNotFoundException;
import com.insurer.app.cardriver.model.CarDriver;
import com.insurer.app.cardriver.repository.CarDriverRepository;
import com.insurer.app.driver.exception.DriverNotFoundException;
import com.insurer.app.driver.model.Driver;
import com.insurer.app.driver.repository.DriverRepository;

@Service
public class CarDriverService {

	@Autowired
	private CarDriverRepository carDriverRepository;
	
	@Autowired
	private CarRepository carRepository;

	@Autowired
	private DriverRepository driverRepository;

	public List<CarDriver> getAllCarDrivers() {
		return carDriverRepository.findAll();
	}

	public CarDriver getCarDriverById(Long id) {
		return carDriverRepository.findById(id)
				.orElseThrow(() -> new CarDriverNotFoundException());
	}

	public CarDriver createCarDriver(CarDriver carDriver) {
		getCar(carDriver);
		getDriver(carDriver);
		
		return carDriverRepository.save(carDriver);
	}
	
	private void getCar(CarDriver carDriver) {
		Car car = carRepository.findById(carDriver.getCar().getCarId())
				.orElseThrow(() -> new CarNotFoundException());
		carDriver.setCar(car);
	}

	private void getDriver(CarDriver carDriver) {
		Driver driver = driverRepository.findById(carDriver.getDriver().getDriverId())
				.orElseThrow(() -> new DriverNotFoundException());
		carDriver.setDriver(driver);
	}

	public CarDriver updateCarDriver(Long id, CarDriver updatedCarDriver) {
		
		CarDriver existingCarDriver = carDriverRepository.findById(id)
				.orElseThrow(() -> new CarDriverNotFoundException());

		updatedCarDriver = carDriverRepository.save(existingCarDriver);
		return updatedCarDriver;
	}

	public void deleteCarDriver(Long id) {
		carDriverRepository.deleteById(id);
	}
}
