package com.insurer.app.driver.test;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.insurer.app.driver.model.Driver;
import com.insurer.app.driver.repository.DriverRepository;
import com.insurer.app.driver.service.DriverService;

@DataJpaTest
public class DriverIntegrationTest {

	@Mock
	private DriverRepository driverRepository;
	
	@InjectMocks
	DriverService driverService;
	
	private static Driver driver;
	
	@BeforeAll
	public static void mockSetup() {
		
		driver = new Driver();
		driver.setDriverId(1L);
		driver.setBirthdate(LocalDate.of(1995, 12, 5));
		driver.setDocument("123456789");
		driver.setHasClaim(false);
		
	}
}
