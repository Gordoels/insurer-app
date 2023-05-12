package com.insurer.app.car.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurer.app.car.model.Car;

public interface CarRepository extends JpaRepository<Car, UUID> {
}
