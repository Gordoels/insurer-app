package com.insurer.app.driver.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "drivers")
public class Driver {
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driverId;

    @Column(name = "document")
    private String document;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "has_claims")
	private boolean hasClaims;
}

