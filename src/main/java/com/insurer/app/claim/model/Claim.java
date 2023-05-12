package com.insurer.app.claim.model;

import java.time.LocalDate;
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
@Table(name = "claims")
public class Claim {
    @Id
    private UUID claimId;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @Column(name = "event_date")
    private LocalDate eventDate;

}

