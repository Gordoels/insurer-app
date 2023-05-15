package com.insurer.app.car.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.insurer.app.car.model.Car;

@DataJpaTest
public class CarIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCarPersistence() {
        
        Car car = new Car();
        car.setCarModel("Model X");
        car.setCarManufacturer("Tesla");
        car.setCarYear(2022);
        car.setFipeValue(50000.0);

        Car savedCar = entityManager.persistAndFlush(car);

        
        assertNotNull(savedCar.getCarId());
        assertEquals("Model X", savedCar.getCarModel());
        assertEquals("Tesla", savedCar.getCarManufacturer());
        assertEquals(2022, savedCar.getCarYear());
        assertEquals(50000.0, savedCar.getFipeValue());
    }
}

