package com.insurer.app.claim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurer.app.claim.model.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
	boolean existsByDriverId(Long driverId);
    boolean existsByCarId(Long carId);
}

