package com.insurer.app.cardriver.model;

import java.util.UUID;

import com.insurer.app.car.model.Car;
import com.insurer.app.driver.model.Driver;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "car_drivers")
public class CarDriver {
    @Id
    private UUID carDriverId;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @Column(name = "is_main_driver")
    private boolean mainDriver;

}
