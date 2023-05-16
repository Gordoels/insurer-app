package com.insurer.app.cardriver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurer.app.cardriver.model.CarDriver;

public interface CarDriverRepository extends JpaRepository<CarDriver, Long> {
}

