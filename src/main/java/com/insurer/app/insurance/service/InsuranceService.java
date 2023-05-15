package com.insurer.app.insurance.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurer.app.car.exception.CarNotFoundException;
import com.insurer.app.car.model.Car;
import com.insurer.app.car.repository.CarRepository;
import com.insurer.app.customer.exception.CustomerNotFoundException;
import com.insurer.app.customer.model.Customer;
import com.insurer.app.customer.repository.CustomerRepository;
import com.insurer.app.driver.repository.DriverRepository;
import com.insurer.app.insurance.exception.InsuranceNotFoundException;
import com.insurer.app.insurance.model.Insurance;
import com.insurer.app.insurance.repository.InsuranceRepository;

@Service
public class InsuranceService {
	
	@Autowired
    private InsuranceRepository insuranceRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private DriverRepository driverRepository;

    public Insurance createInsurance(Insurance insurance) {
        getCar(insurance);
        getCustomer(insurance);
    	
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

        isAgeLegal(customer.getDriver().getBirthdate());
        
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

    private boolean isAgeLegal(LocalDate birthdate) {
    	LocalDate presentDay = LocalDate.now();
    	int age = Period.between(birthdate, presentDay).getYears();
    	
    	return (age >= 18) ? true : false;
    }
    public boolean hasClaimInDriver(Long driverId) {
    	boolean driverHasClaim = driverRepository.existsByDriverIdAndHasClaim(driverId, true);
        return driverHasClaim;
    }

    public boolean hasClaimInCar(Long carId) {
    	boolean carHasClaim = carRepository.existsByCarIdAndHasClaim(carId, true);
        return carHasClaim;
    }
    
    private void getCar(Insurance insurance) {
    	Car car = carRepository.findById(insurance.getCar().getCarId()).orElseThrow(() -> new CarNotFoundException());
        insurance.setCar(car);
    }
    
    private void getCustomer(Insurance insurance) {
    	Customer customer = customerRepository.findById(insurance.getCustomer().getCustomerId()).orElseThrow(() -> new CustomerNotFoundException());
        insurance.setCustomer(customer);
    }

    public Insurance getInsuranceById(Long insuranceId) {
        return insuranceRepository.findById(insuranceId)
                .orElseThrow(() -> new InsuranceNotFoundException());
    }

    public Insurance updateInsurance(Long insuranceId, Insurance updatedInsurance) {

        Insurance existingInsurance = insuranceRepository.findById(insuranceId)
                .orElseThrow(() -> new InsuranceNotFoundException());

        existingInsurance.setActive(updatedInsurance.isActive());

        existingInsurance = insuranceRepository.save(updatedInsurance);

        return updatedInsurance;
    }

    public Insurance updateInsuranceStatus(Long insuranceId, boolean active) {
        Insurance insurance = insuranceRepository.findById(insuranceId)
                .orElseThrow(() -> new InsuranceNotFoundException());

        insurance.setActive(active);
        return insuranceRepository.save(insurance);
    }


	public void deleteInsurance(Long insuranceId) {
		Insurance insurance = getInsuranceById(insuranceId);
        insuranceRepository.delete(insurance);
	}

}


