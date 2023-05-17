package com.insurer.app.car.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.insurer.app.car.model.Car;
import com.insurer.app.car.repository.CarRepository;
import com.insurer.app.car.service.CarService;

@DataJpaTest
public class CarIntegrationTest {

	@Mock
	private CarRepository carRepository;

	@InjectMocks
	CarService carService;

	private static Car car;

	@BeforeAll
	public static void mockSetup() {

		car = new Car();
		car.setCarId(1L);
		car.setCarModel("Model X");
		car.setCarManufacturer("Tesla");
		car.setCarYear(2022);
		car.setFipeValue(10000.0);
		car.setHasClaim(false);

	}

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
    public void testCreateCarService() {

    	when(carRepository.save(car)).thenReturn(car);
        
        assertNotNull(car.getCarId());
        assertEquals("Model X", car.getCarModel());
        assertEquals("Tesla", car.getCarManufacturer());
        assertEquals(2022, car.getCarYear());
        assertEquals(10000.0, car.getFipeValue());
        assertEquals(false, car.getCarYear());
    }
}
