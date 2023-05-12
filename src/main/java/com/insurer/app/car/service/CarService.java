package com.insurer.app.car.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurer.app.car.model.Car;
import com.insurer.app.car.repository.CarRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CarService {

	@Autowired
    private CarRepository carRepository;
    
    public Car createCar(Car car) {
        return carRepository.save(car);
    }
    
    public Car getCarById(UUID id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car with id " + id + " not found"));
    }
    
}

