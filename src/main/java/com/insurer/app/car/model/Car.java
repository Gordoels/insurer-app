package com.insurer.app.car.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cars")
public class Car {
	@Id
	private UUID carId;

	@Column(name = "carModel")
	private String carModel;

	@Column(name = "carManufacturer")
	private String carManufacturer;

	@Column(name = "carYear")
	private int carYear;

	@Column(name = "fipe_value")
	private Double fipeValue;

}
