package com.insurer.app.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurer.app.car.exception.CarNotFoundException;
import com.insurer.app.car.model.Car;
import com.insurer.app.car.repository.CarRepository;

@Service
public class CarService {

	@Autowired
    private CarRepository carRepository;
    
    public Car createCar(Car car) {
        return carRepository.save(car);
    }
    
    public Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException());
    }
    
}

