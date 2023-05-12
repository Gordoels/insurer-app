package com.insurer.app.insurance.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.insurer.app.car.model.Car;
import com.insurer.app.customer.model.Customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "insurances")
public class Insurance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long insuranceId;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Column(name = "creation_dt")
	private LocalDate creationDate;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "car_id")
	private Car car;

	@Column(name = "is_active")
	private boolean active;

	@Column(name = "insurance_budget")
	private Double insuranceBudget;

}
