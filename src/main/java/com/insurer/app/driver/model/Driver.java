package com.insurer.app.driver.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    private UUID driverId;

    @Column(name = "document")
    private String document;

    @Column(name = "birthdate")
    private LocalDate birthdate;

}

