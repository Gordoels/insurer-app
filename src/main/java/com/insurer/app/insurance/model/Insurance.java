package com.insurer.app.insurance.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.insurer.app.car.model.Car;
import com.insurer.app.customer.model.Customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "insurances")
public class Insurance {
	@Id
	private UUID insuranceId;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Column(name = "creation_dt")
	private LocalDate creationDate;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@ManyToOne
	@JoinColumn(name = "car_id")
	private Car car;

	@NotNull
	@Column(name = "is_active")
	private Boolean active;

	@Column(name = "insurance_budget")
	private Double insuranceBudget;

	public Insurance(UUID insuranceId, Customer customer, LocalDate creationDate, LocalDateTime updatedAt, Car car,
			Boolean active, Double insuranceBudget) {
		this.insuranceId = insuranceId;
		this.customer = customer;
		this.creationDate = creationDate;
		this.updatedAt = updatedAt;
		this.car = car;
		this.active = active;
		this.insuranceBudget = insuranceBudget;
	}
}
