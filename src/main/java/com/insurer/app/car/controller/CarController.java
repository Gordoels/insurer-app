package com.insurer.app.car.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurer.app.car.model.Car;
import com.insurer.app.car.service.CarService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cars")
public class CarController {

	@Autowired
    private CarService carService;
    
    @PostMapping
    public ResponseEntity<Car> createCar(@Valid @RequestBody Car car) {
        Car savedCar = carService.createCar(car);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public Car getCarById(@PathVariable UUID id) {
        return carService.getCarById(id);
    }
    
}
