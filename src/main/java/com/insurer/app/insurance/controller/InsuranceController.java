package com.insurer.app.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurer.app.insurance.dto.InsuranceStatusPatchDTO;
import com.insurer.app.insurance.model.Insurance;
import com.insurer.app.insurance.service.InsuranceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/insurance/budget")
public class InsuranceController {
	@Autowired
    private InsuranceService insuranceService;

    @PostMapping
    public ResponseEntity<Insurance> createInsurance(@Valid @RequestBody Insurance insurance) {
        Insurance createdInsurance = insuranceService.createInsurance(insurance);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInsurance);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Insurance> getInsuranceById(@PathVariable Long id) {
        Insurance insurance = insuranceService.getInsuranceById(id);
        return ResponseEntity.ok(insurance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Insurance> updateInsurance(
            @PathVariable Long id, @RequestBody Insurance updatedInsurance) {
        Insurance insurance = insuranceService.updateInsurance(id, updatedInsurance);
        return ResponseEntity.ok(insurance);
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<Insurance> activeSwitchInsurance(@PathVariable Long id, @RequestBody InsuranceStatusPatchDTO patchDTO) {
        Insurance insurance = insuranceService.updateInsuranceStatus(id, patchDTO.isActive());
        return ResponseEntity.ok(insurance);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInsurance(@PathVariable Long id) {
        insuranceService.deleteInsurance(id);
        return ResponseEntity.noContent().build();
    }
}

