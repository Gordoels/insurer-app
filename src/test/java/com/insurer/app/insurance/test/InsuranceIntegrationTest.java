package com.insurer.app.insurance.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.insurer.app.car.model.Car;
import com.insurer.app.customer.model.Customer;
import com.insurer.app.driver.model.Driver;
import com.insurer.app.insurance.model.Insurance;

@DataJpaTest
public class InsuranceIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateInsurancePersistence() {
        
        Car car = new Car();
        car.setCarModel("Model X");
        car.setCarManufacturer("Tesla");
        car.setCarYear(2022);
        car.setFipeValue(10000.0);
        car.setHasClaims(false);
        
        Driver driver = new Driver();
        driver.setBirthdate(LocalDate.of(1995, 12, 5));
        driver.setDocument("123456789");
        driver.setHasClaims(false);

        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setDriver(driver);

        entityManager.persistAndFlush(car);
        entityManager.persistAndFlush(driver);
        entityManager.persistAndFlush(customer);

        
        Insurance insurance = new Insurance();
        insurance.setCar(car);
        insurance.setCustomer(customer);
        insurance.setInsuranceBudget(600.0);

        Insurance savedInsurance = entityManager.persistAndFlush(insurance);

        
        assertNotNull(savedInsurance.getInsuranceId());
        assertEquals(car.getCarId(), savedInsurance.getCar().getCarId());
        assertEquals(customer.getCustomerId(), savedInsurance.getCustomer().getCustomerId());
        assertEquals(600.0, savedInsurance.getInsuranceBudget());
    }
}

