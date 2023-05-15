package com.insurer.app.claim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurer.app.claim.model.Claim;


public interface ClaimRepository extends JpaRepository<Claim, Long> {
}

