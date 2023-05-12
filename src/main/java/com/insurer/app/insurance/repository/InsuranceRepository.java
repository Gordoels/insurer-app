package com.insurer.app.insurance.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurer.app.insurance.model.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, UUID> {
}
