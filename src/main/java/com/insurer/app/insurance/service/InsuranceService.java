package com.insurer.app.insurance.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurer.app.car.model.Car;
import com.insurer.app.car.repository.CarRepository;
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

    public Insurance createInsurance(Insurance insurance) {
        getCarObject(insurance);
        getCustomerObject(insurance);
    	
        double baseRate = calculateBaseRate(insurance.getCar().getFipeValue());
        double riskRate = calculateRiskRate(insurance.getCustomer(), insurance.getCar());
        double totalRate = baseRate + riskRate;

        insurance.setInsuranceBudget(totalRate);
        return insuranceRepository.save(insurance);
    }

    private double calculateBaseRate(double fipeValue) {
        double baseRatePercentage = 0.06;
        return fipeValue * baseRatePercentage;
    }

    private double calculateRiskRate(Customer customer, Car car) {
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

    private boolean hasClaimInDriver(UUID driverId) {
    	return true;
    }

    private boolean hasClaimInCar(UUID carId) {
        return false;
    }
    
    private void getCarObject(Insurance insurance) {
    	Car car = carRepository.findById(insurance.getCar().getCarId()).orElseThrow(() -> new EntityNotFoundException("Car not found"));
        insurance.setCar(car);
    }
    
    private void getCustomerObject(Insurance insurance) {
    	Customer customer = customerRepository.findById(insurance.getCustomer().getCustomerId()).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        insurance.setCustomer(customer);
    }

	public Insurance getInsuranceById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Insurance> getAllInsurances() {
		// TODO Auto-generated method stub
		return null;
	}

	public Insurance updateInsurance(UUID id, Insurance updatedInsurance) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteInsurance(UUID id) {
		// TODO Auto-generated method stub
		
	}

}


