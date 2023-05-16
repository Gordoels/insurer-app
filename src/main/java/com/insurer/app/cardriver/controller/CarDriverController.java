package com.insurer.app.cardriver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurer.app.cardriver.model.CarDriver;
import com.insurer.app.cardriver.service.CarDriverService;

@RestController
@RequestMapping("/cardrivers")
public class CarDriverController { 
    
	@Autowired
	private CarDriverService carDriverService;


    @GetMapping
    public List<CarDriver> getAllCarDrivers() {
        return carDriverService.getAllCarDrivers();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CarDriver> getCarDriverById(@PathVariable Long id) {
    	CarDriver carDriver = carDriverService.getCarDriverById(id);
        return ResponseEntity.ok(carDriver);
    }

    @PostMapping
    public CarDriver createCarDriver(@RequestBody CarDriver carDriver) {
        return carDriverService.createCarDriver(carDriver);
    }
}

