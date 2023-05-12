package com.insurer.app.insurance.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurer.app.car.model.Car;
import com.insurer.app.car.repository.CarRepository;
import com.insurer.app.claim.repository.ClaimRepository;
import com.insurer.app.customer.model.Customer;
import com.insurer.app.customer.repository.CustomerRepository;
import com.insurer.app.insurance.model.Insurance;
import com.insurer.app.insurance.repository.InsuranceRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InsuranceService {
	
	@Autowired
    private InsuranceRepository insuranceRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ClaimRepository claimRepository;

    public Insurance createInsurance(Insurance insurance) {
        getCarObject(insurance);
        getCustomerObject(insurance);
    	
        Double baseRate = calculateBaseRate(insurance.getCar().getFipeValue());
        Double riskRate = calculateRiskRate(insurance.getCustomer(), insurance.getCar());
        Double totalRate = baseRate + riskRate;

        insurance.setInsuranceBudget(totalRate);
        return insuranceRepository.save(insurance);
    }

    private Double calculateBaseRate(double fipeValue) {
        double baseRatePercentage = 0.06;
        return fipeValue * baseRatePercentage;
    }

    private Double calculateRiskRate(Customer customer, Car car) {
        double riskRatePercentage = 0.0;

        if (isAgeInRange(customer.getDriver().getBirthdate(), 18, 25)) {
            riskRatePercentage += 0.02;
        }

        if (hasClaimInDriver(customer.getDriver().getDriverId())) {
            riskRatePercentage += 0.02;
        }

        if (hasClaimInCar(car.getCarId())) {
            riskRatePercentage += 0.02;
        }

        return car.getFipeValue() * riskRatePercentage;
    }

    private boolean isAgeInRange(LocalDate birthdate, int minAge, int maxAge) {
        LocalDate minDate = LocalDate.now().minusYears(maxAge);
        LocalDate maxDate = LocalDate.now().minusYears(minAge).plusDays(1);
        return birthdate.isAfter(minDate) && birthdate.isBefore(maxDate);
    }

    public boolean hasClaimInDriver(Long driverId) {
        return claimRepository.existsByDriverDriverId(driverId);
    }

    public boolean hasClaimInCar(Long carId) {
        return claimRepository.existsByCarCarId(carId);
    }
    
    private void getCarObject(Insurance insurance) {
    	Car car = carRepository.findById(insurance.getCar().getCarId()).orElseThrow(() -> new EntityNotFoundException("Car not found"));
        insurance.setCar(car);
    }
    
    private void getCustomerObject(Insurance insurance) {
    	Customer customer = customerRepository.findById(insurance.getCustomer().getCustomerId()).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        insurance.setCustomer(customer);
    }

    public Insurance getInsuranceById(Long insuranceId) {
        return insuranceRepository.findById(insuranceId)
                .orElseThrow(() -> new EntityNotFoundException("Insurance with id " + insuranceId + " not found"));
    }

    public Insurance updateInsurance(Long insuranceId, Insurance updatedInsurance) {

        Insurance existingInsurance = insuranceRepository.findById(insuranceId)
                .orElseThrow(() -> new EntityNotFoundException("Insurance with id " + insuranceId + " not found"));

        existingInsurance.setActive(updatedInsurance.isActive());

        existingInsurance = insuranceRepository.save(updatedInsurance);

        return updatedInsurance;
    }

    public Insurance updateInsuranceStatus(Long insuranceId, boolean active) {
        Insurance insurance = insuranceRepository.findById(insuranceId)
                .orElseThrow(() -> new EntityNotFoundException("Insurance with id " + insuranceId + " not found"));

        insurance.setActive(active);
        return insuranceRepository.save(insurance);
    }


	public void deleteInsurance(Long insuranceId) {
		Insurance insurance = getInsuranceById(insuranceId);
        insuranceRepository.delete(insurance);
	}

}


