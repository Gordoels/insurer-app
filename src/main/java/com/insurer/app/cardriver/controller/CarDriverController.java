package com.insurer.app.cardriver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurer.app.cardriver.model.CarDriver;
import com.insurer.app.cardriver.service.CarDriverService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cardrivers")
public class CarDriverController {

	@Autowired
	private CarDriverService carDriverService;

	@PostMapping
	public ResponseEntity<CarDriver> createCarDriver(@Valid @RequestBody CarDriver carDriver) {
		CarDriver createdCarDriver = carDriverService.createCarDriver(carDriver);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdCarDriver);
	}

	@GetMapping
	public List<CarDriver> getAllCarDrivers() {
		return carDriverService.getAllCarDrivers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CarDriver> getCarDriverById(@PathVariable Long id) {
		CarDriver carDriver = carDriverService.getCarDriverById(id);
		return ResponseEntity.ok(carDriver);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CarDriver> updateCarDriver(@PathVariable Long id, @RequestBody CarDriver carDriver) {
		CarDriver updatedCarDriver = carDriverService.updateCarDriver(id, carDriver);
		return ResponseEntity.ok(updatedCarDriver);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCarDriver(@PathVariable Long id) {
		carDriverService.deleteCarDriver(id);
		return ResponseEntity.noContent().build();
	}
}
